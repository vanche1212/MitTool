package com.zrtg.mittoolcore.response;


public enum CommonEnum {

	SUCCESS(200, "请求成功"),
	ERROR(400, "请求失败"),

	NULL_POINTER(400, "空指针异常！"),
	UNKNOWN_ERROR(400, "未知异常！"),
	FOREST_ERROR(400, "远程调用失败！"),
	;

	private Integer code;

	private String msg;

	CommonEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
