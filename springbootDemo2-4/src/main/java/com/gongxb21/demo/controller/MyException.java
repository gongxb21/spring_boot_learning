package com.gongxb21.demo.controller;

/**
 * @author gongxb
 *
 * 2017年12月24日
 */
public class MyException  extends RuntimeException{
	
	/**
	 * @param code
	 * @param errMsg
	 */
	public MyException(String code, String errMsg) {
		super();
		this.code = code;
		this.errMsg = errMsg;
	}
	private String code;
	private String errMsg;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	@Override
	public String toString() {
		return "MyException [code=" + code + ", errMsg=" + errMsg + "]";
	}
	
}
