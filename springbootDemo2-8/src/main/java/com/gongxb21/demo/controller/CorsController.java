package com.gongxb21.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gongxb
 *
 * 2017年12月31日
 */
@RestController
@RequestMapping(value="/corsController")
public class CorsController {
	
	
	@CrossOrigin(origins="http://localhost:8080")
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public Map get() {
		System.out.println("get method");
		Map<String,String> map =new HashMap<String,String>();
		map.put("title", "book");
		map.put("name", "spring boot in action");
		return map;
	}
}
