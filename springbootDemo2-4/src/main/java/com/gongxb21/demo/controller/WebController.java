
package com.gongxb21.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gongxb
 *
 * 2017年12月24日
 */
@Controller
@RequestMapping("/web")
public class WebController {
	private static final Logger logger =  LoggerFactory.getLogger(WebController.class);

	@RequestMapping("/init")
	//没有搞明白，为什么不能加载webjars下面的js文件
	public String init(ModelMap map) {
		logger.info("这里是controller");  
		map.put("title", "hello world");
		return "index"; // 注意，不要在最前面加上/，linux下面会出错
	}
	
	@GetMapping(value="/index")
	public String index() {
		throw new MyException("100","this is null");
	}
}
