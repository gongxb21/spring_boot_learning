package com.gongxb21.demo.json;

import com.gongxb21.demo.bean.MyExceptionEnum;

/**
 * @author gongxb
 *
 * 2017年12月25日
 */
public class AjaxResult {
	private static final int SUCCESS=0;
	private Object data;
	private int code;
	private String errMsg;
	
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

	public Object getObj() {
		return data;
	}

	public void setObj(Object obj) {
		this.data = obj;
	}

  public AjaxResult success(Object data) {
	this.setCode(AjaxResult.SUCCESS);
	this.setErrMsg(null);
    this.data = data;
    return this;
  }
  public AjaxResult success() {
	  return success(null);
  }
  
  public AjaxResult fail(int code,String errMsg) {
	  AjaxResult ar=new AjaxResult();
	  ar.code=-1;
	  ar.errMsg="未知系统错误";
	  return  ar;
  }
  public AjaxResult fail(MyExceptionEnum myEnum) { 
	  AjaxResult ar=new AjaxResult();
	  this.code=myEnum.getCode();
	this.errMsg=myEnum.getErrMsg();
	  return  ar;
  }
  public AjaxResult fail() {
	  AjaxResult ar=new AjaxResult();
	  ar.code=-1;
	  ar.errMsg="未知系统错误";
	  return  ar;
  }
  
}
