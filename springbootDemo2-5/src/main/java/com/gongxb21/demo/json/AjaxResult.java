package com.gongxb21.demo.json;


/**
 * @author gongxb
 *
 * 2017年12月25日
 */
public class AjaxResult {
	private static final String SUCCESS="OK";
	private static final String FAIL="ERROR";
	
	private Meta meta;
	private Object data;
	
	
	public Meta getMeta() {
		return meta;
	}


	public void setMeta(Meta meta) {
		this.meta = meta;
	}


	public Object getObj() {
		return data;
	}


	public void setObj(Object obj) {
		this.data = obj;
	}

	 public AjaxResult success() {
	    this.meta = new Meta(true, SUCCESS);
	    return this;
	  }

	  public AjaxResult success(Object data) {
	    this.meta = new Meta(true, SUCCESS);
	    this.data = data;
	    return this;
	  }

	  public AjaxResult failure() {
	    this.meta = new Meta(false, FAIL);
	    return this;
	  }

	  public AjaxResult failure(String message) {
	    this.meta = new Meta(false, message);
	    return this;
	  }
	public class Meta {

	    private boolean success;
	    private String message;

	    public Meta(boolean success) {
	      this.success = success;
	    }

	    public Meta(boolean success, String message) {
	      this.success = success;
	      this.message = message;
	    }

	    public boolean isSuccess() {
	      return success;
	    }

	    public String getMessage() {
	      return message;
	    }
	  }
}
