package com.zrtg.mittoolcorelog.log;


import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Aspect
@Setter
@Getter
public class WebLogAspect {

    private boolean request = false;
    private boolean response = false;

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@within(com.zrtg.mittoolcorelog.annotation.WebLog)")
    public void webLog(){}

    public MtRequest doBefore(ProceedingJoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        MtRequest mtRequest = new MtRequest();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //打印请求参数
        Map<String, String[]> paramMap = request.getParameterMap();
        List<MtParam> paramList = new ArrayList<>();
        mtRequest.setRequestParams(paramList);
        if(paramMap != null && paramMap.size() > 0) {
            for(String mapKey:paramMap.keySet()) {
                String[] mapValue = paramMap.get(mapKey);
                if(mapValue != null && mapValue.length > 0) {
                    for(String paramStr:mapValue) {
                        if(!StringUtils.isEmpty(paramStr)) {
                            MtParam mtParam = new MtParam();
                            mtParam.setKey(mapKey);
                            mtParam.setValue(paramStr);
                            paramList.add(mtParam);
                        }
                    }
                }
            }
            //打印日志参数
            logger.info("===> 请求参数: " + "");
        }
        // 记录下请求内容
        mtRequest.setRequestUrl(request.getRequestURL().toString());
        mtRequest.setRequestMethod(request.getMethod());
        mtRequest.setRequestIp(getIP(request));
        mtRequest.setRequestClass(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        mtRequest.setRequestData(Arrays.toString(joinPoint.getArgs()));
        return mtRequest;
    }

    public MtRequest doAfterReturning(Object ret, MtRequest mtRequest) {
        // 返回内容
        mtRequest.setResponseResult(ret.toString());
        // 响应时间
        if (startTime.get() != null) {
            mtRequest.setResponseTime((System.currentTimeMillis() - startTime.get()) + "");
        }
        return mtRequest;
    }

    @Around("webLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        try{
            MtRequest mtRequest = new MtRequest();
            if (request) {
                mtRequest = doBefore(pjp);
            }
            Object object = pjp.proceed();
            if (response) {
                mtRequest = doAfterReturning(object, mtRequest);
            }
            logger.info("请求日志：" + JSON.toJSONString(mtRequest));
            return object;
        }catch (Throwable e){
            throw e;
        }
    }


    /**
     * 获取IP
     */
    public static String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
