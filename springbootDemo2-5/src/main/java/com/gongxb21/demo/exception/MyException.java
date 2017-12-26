package com.gongxb21.demo.exception;

import com.gongxb21.demo.bean.MyExceptionEnum;

/**
 * @author gongxb
 *
 * 2017年12月26日
 */
public class MyException extends RuntimeException {
	private int code;
	private String errMsg;
	
	/**
	 * @param code
	 * @param errMsg
	 */
	public MyException(int code, String errMsg) {
		super();
		this.code = code;
		this.errMsg = errMsg;
	}

	public MyException(MyExceptionEnum myEnum) {
		super();
		this.code=myEnum.getCode();
		this.errMsg=myEnum.getErrMsg();
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
	
}
