package com.zrtg.mittoolcommon.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zrtg.mittoolcommon.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局系统异常处理
 *
 * @author hxrui
 * @date 2020-02-25 13:54
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public CommonResult handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("非法参数异常，异常原因：{}",e.getMessage(),e);
        return CommonResult.failed(e.getMessage());
    }


    @ExceptionHandler(JsonProcessingException.class)
    public CommonResult handleJsonProcessingException(JsonProcessingException e) {
        log.error("Json转换异常，异常原因：{}",e.getMessage(),e);
        return CommonResult.failed(e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public CommonResult handleBizException(BizException e) {
        return CommonResult.failed(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResult handleException(Exception e) {
        log.error("未知异常，异常原因：{}",e.getMessage(),e);
        return CommonResult.failed(e.getMessage());
    }
}
