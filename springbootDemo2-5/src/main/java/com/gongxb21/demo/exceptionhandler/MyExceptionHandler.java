package com.gongxb21.demo.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gongxb21.demo.bean.MyExceptionEnum;
import com.gongxb21.demo.exception.MyException;
import com.gongxb21.demo.json.AjaxResult;

/**
 * @author gongxb
 *
 * 2017年12月26日
 */
@ControllerAdvice
public class MyExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public AjaxResult handlerException(Exception ex) {
		Logger logger =LoggerFactory.getLogger(MyExceptionHandler.class);
		AjaxResult ajaxResult=new AjaxResult();
		if(ex instanceof MyException) {
			ajaxResult.setCode(((MyException) ex).getCode());
			ajaxResult.setErrMsg(((MyException) ex).getErrMsg());
			return ajaxResult;
		}else {
			logger.error("【未知系统异常】"+ex.getMessage());
			return ajaxResult.fail(MyExceptionEnum.UNKNOWN_ERROR);
		}
	}
}
