package com.gongxb21.demo.bean;

/**
 * @author gongxb
 *
 * 2017年12月26日
 */
public enum MyExceptionEnum {
	UNKNOWN_ERROR(-1,"未知系统错误"),
	SUCCESS(0,"成功"),
	CHILD_ERROR(1,"你还只是个孩子"),
	ADULT_ERROR(2,"你已经不是孩子了，但还没有到中年")
	;
	private Integer code;
	private String errMsg;
	/**
	 * @param code
	 * @param errMsg
	 */
	private MyExceptionEnum(Integer code, String errMsg) {
		this.code = code;
		this.errMsg = errMsg;
	}
	public Integer getCode() {
		return code;
	}
	public String getErrMsg() {
		return errMsg;
	}
	
}
