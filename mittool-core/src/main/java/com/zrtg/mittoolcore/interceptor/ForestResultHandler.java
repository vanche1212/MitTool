package com.zrtg.mittoolcore.interceptor;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * forest自身，无法捕获到ForestRuntimeException异常
 */
@Aspect
public class ForestResultHandler {

    private Logger logger = LoggerFactory.getLogger(ForestResultHandler.class);

    @Pointcut("@annotation(com.zrtg.mittoolcore.annotation.ForestResult)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (ForestRuntimeException e) {
            logger.error("请求异常：", e);
            return null;
        }
    }

}
