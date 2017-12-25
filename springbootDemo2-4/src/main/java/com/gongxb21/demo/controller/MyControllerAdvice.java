package com.gongxb21.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gongxb
 *
 * 2017年12月24日
 */
@ControllerAdvice
public class MyControllerAdvice {
	@ResponseBody
	@ExceptionHandler(value=MyException.class)
	public Map myErrorHandler(MyException ex) {
		Map map=new HashMap();
		map.put("code", ex.getCode());
		map.put("errMsg", ex.getErrMsg());
		return map;
		
	}
}
