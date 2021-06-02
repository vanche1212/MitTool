package com.zrtg.mittoolcore.response;


import lombok.Data;

@Data
public class Message<T> {

    private final int code;

    private final String msg;

    private T data;

    public Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Message(int code, String msg, T data) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static <T> Message<T> custom(int code, String msg) {
        return new Message<T>(code, msg);
    }

    public static <T> Message<T> custom(int code, String msg, T data) {
        return new Message<T>(code, msg, data);
    }

    public static <T> Message<T> custom(CommonEnum commonEnum) {
        return new Message<T>(commonEnum.getCode(),commonEnum.getMsg());
    }

    public static <T> Message<T> custom(CommonEnum commonEnum, T data) {
        return new Message<T>(commonEnum.getCode(), commonEnum.getMsg(), data);
    }

}
