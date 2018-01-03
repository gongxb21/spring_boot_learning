package com.gongxb21.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gongxb21.demo.dynamtictask.DynamticTask;

/**
 * @author gongxb
 *
 * 2018年1月3日
 */
//@Controller
public class WebController {
	@Autowired
	DynamticTask task;
	
	@ResponseBody
	@RequestMapping("/index")
	public String index() {
		System.out.println("index method");
		task.setCronExpression("0/3 * * * * ?");
		return "success";
	}
}
