package com.zrtg.mittoolcore.log;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;


@Aspect
@Setter
@Getter
public class WebLogAspect {

    private boolean request = false;
    private boolean response = false;


    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@within(com.zrtg.mittoolcore.annotation.WebLog)")
    public void webLog(){}

    public void doBefore(ProceedingJoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //打印请求参数
        Map<String, String[]> paramMap = request.getParameterMap();
        if(paramMap != null && paramMap.size() > 0) {
            StringBuffer paramSbf = new StringBuffer();
            for(String mapKey:paramMap.keySet()) {
                String[] mapValue = paramMap.get(mapKey);
                if(mapValue != null && mapValue.length > 0) {
                    for(String paramStr:mapValue) {
                        if(StringUtils.isNotBlank(paramStr)) {
                            paramSbf.append("参数"+mapKey+"=");
                            paramSbf.append(paramStr);
                            paramSbf.append(";");
                        }
                    }
                }
            }
            //打印日志参数
            logger.info("===> 请求参数: " + paramSbf);
        }
        // 记录下请求内容
        logger.info("===> 请求URL: " + request.getRequestURL().toString());
        logger.info("===> 请求方式: " + request.getMethod());
        logger.info("===> 请求IP: " + getIP(request));
        logger.info("===> 请求类方法: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("===> 请求数据: " + Arrays.toString(joinPoint.getArgs()));
    }

    public void doAfterReturning(Object ret) {
        // 返回内容
        logger.info("===> 响应结果: " + ret);
        // 响应时间
        if (startTime.get() != null) {
            logger.info("===> 响应时间【" + (System.currentTimeMillis() - startTime.get()) + "】毫秒");
        }
    }

    @Around("webLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        try{
            if (request) {
                doBefore(pjp);
            }
            Object object = pjp.proceed();
            if (response) {
                doAfterReturning(object);
            }
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
