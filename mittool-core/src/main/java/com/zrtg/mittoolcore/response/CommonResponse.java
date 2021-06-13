package com.zrtg.mittoolcore.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Deprecated
public class CommonResponse<T> extends ResponseEntity<Message<T>> implements Serializable {

    private static final long serialVersionUID = 1823611267210679876L;

    public int getCode() {
        return this.getBody().getCode();
    }

    public String getMsg() {
        return this.getBody().getMsg();
    }

    public T getData() {
        return ((T) this.getBody().getData());
    }


    // 下面开始构建一些构造方法，用于静态方法调用
    public CommonResponse(int code, String msg, HttpStatus httpStatus) {
        super(Message.custom(code, msg), httpStatus);
    }
    public CommonResponse(int code, String msg, T data, HttpStatus httpStatus) {
        super(Message.custom(code, msg, data), httpStatus);
    }
    public CommonResponse(CommonEnum commonEnum, HttpStatus httpStatus) {
        super(Message.custom(commonEnum), httpStatus);
    }
    public CommonResponse(CommonEnum commonEnum, T data, HttpStatus httpStatus) {
        super(Message.custom(commonEnum, data), httpStatus);
    }


    public static CommonResponse buildSuccess() {
        return new CommonResponse(CommonEnum.SUCCESS, HttpStatus.OK);
    }
    public static CommonResponse buildSuccess(String msg) {
        return new CommonResponse(CommonEnum.SUCCESS.getCode(), msg, HttpStatus.OK);
    }
    public static CommonResponse buildSuccess(int code, String msg) {
        return new CommonResponse(code, msg, HttpStatus.OK);
    }
    public static <T> CommonResponse<T> buildSuccess(T data) {
        return new CommonResponse<T>(CommonEnum.SUCCESS, data, HttpStatus.OK);
    }
    public static <T> CommonResponse<T> buildSuccess(String msg, T data) {
        return new CommonResponse<T>(CommonEnum.SUCCESS.getCode(), msg, data, HttpStatus.OK);
    }
    public static <T> CommonResponse<T> buildSuccess(int code, String msg, T data) {
        return new CommonResponse<T>(code, msg, data, HttpStatus.OK);
    }
    public static <T> CommonResponse<T> buildSuccess(CommonEnum commonEnum, T data) {
        return new CommonResponse<T>(commonEnum, data, HttpStatus.OK);
    }
    public static CommonResponse buildSuccess(CommonEnum commonEnum) {
        return new CommonResponse(commonEnum, HttpStatus.OK);
    }
    // 失败的方法(可以定制status)
    public static CommonResponse<String> buildError() {
        return new CommonResponse(CommonEnum.ERROR, HttpStatus.OK);
    }
    public static CommonResponse buildError(HttpStatus httpStatus) {
        return new CommonResponse(CommonEnum.ERROR, httpStatus);
    }
    public static CommonResponse buildError(String msg) {
        return new CommonResponse(CommonEnum.ERROR.getCode(), msg, HttpStatus.OK);
    }
    public static CommonResponse buildError(String msg, HttpStatus httpStatus) {
        return new CommonResponse(CommonEnum.ERROR.getCode(), msg, httpStatus);
    }
    public static CommonResponse buildError(int code, String msg) {
        return new CommonResponse(code, msg, HttpStatus.OK);
    }
    public static CommonResponse buildError(int code, String msg, HttpStatus httpStatus) {
        return new CommonResponse(code, msg, httpStatus);
    }
    public static <T> CommonResponse<T> buildError(T data) {
        return new CommonResponse<T>(CommonEnum.ERROR, data, HttpStatus.OK);
    }
    public static <T> CommonResponse<T> buildError(T data, HttpStatus httpStatus) {
        return new CommonResponse<T>(CommonEnum.ERROR, data, httpStatus);
    }
    public static <T> CommonResponse<T> buildError(String msg, T data) {
        return new CommonResponse<T>(CommonEnum.ERROR.getCode(), msg, data, HttpStatus.OK);
    }
    public static <T> CommonResponse<T> buildError(String msg, T data, HttpStatus httpStatus) {
        return new CommonResponse<T>(CommonEnum.ERROR.getCode(), msg, data, httpStatus);
    }
    public static <T> CommonResponse<T> buildError(int code, String msg, T data) {
        return new CommonResponse<T>(code, msg, data, HttpStatus.OK);
    }
    public static <T> CommonResponse<T> buildError(int code, String msg, T data, HttpStatus httpStatus) {
        return new CommonResponse<T>(code, msg, data, httpStatus);
    }
    public static <T> CommonResponse<T> buildError(CommonEnum commonEnum, T data) {
        return new CommonResponse<T>(commonEnum, data, HttpStatus.OK);
    }
    public static <T> CommonResponse<T> buildError(CommonEnum commonEnum, T data, HttpStatus httpStatus) {
        return new CommonResponse<T>(commonEnum, data, httpStatus);
    }
    public static CommonResponse buildError(CommonEnum commonEnum) {
        return new CommonResponse(commonEnum, HttpStatus.OK);
    }
    public static CommonResponse buildError(CommonEnum commonEnum, HttpStatus httpStatus) {
        return new CommonResponse(commonEnum, httpStatus);
    }



}
