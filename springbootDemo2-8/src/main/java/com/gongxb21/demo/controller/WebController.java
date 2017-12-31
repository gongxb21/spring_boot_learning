package com.gongxb21.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gongxb
 *
 * 2017年12月31日
 */

@Controller
public class WebController {
	private static final Logger logger=LoggerFactory.getLogger(WebController.class);
	@RequestMapping("/index")
	public String index(ModelMap map) {
		logger.info("index method ");
		map.put("title", "hahaha");
		return "index";
	}
	@RequestMapping("/err")
	public String error() {
		logger.info(" err metohd hahah");
		throw new RuntimeException("抛异常");
	}
	
}
