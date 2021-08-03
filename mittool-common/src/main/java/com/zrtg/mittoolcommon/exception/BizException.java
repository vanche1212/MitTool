package com.zrtg.mittoolcommon.exception;

import com.zrtg.mittoolcommon.result.IErrorCode;
import com.zrtg.mittoolcommon.result.ResultCode;
import lombok.Getter;

@Getter
public class BizException extends RuntimeException {

    public IErrorCode resultCode;

    public BizException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.resultCode = errorCode;
    }

    public BizException(String message){
        super(message);
    }

    public BizException(String message, Throwable cause){
        super(message, cause);
    }

    public BizException(Throwable cause){
        super(cause);
    }
}
