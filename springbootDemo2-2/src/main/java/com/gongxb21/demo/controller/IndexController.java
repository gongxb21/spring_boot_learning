/**
 * Administrator 
 * 下午1:22:23 yy/MM/dd
 */
package com.gongxb21.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongxb21.demo.bean.Book;

/**
 * @author gongxb
 *
 * 2017年12月23日
 */

@RestController
@RequestMapping("/web")
public class IndexController {
	public static final Logger logger=LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value={"index","hi"})
	//可以使用集合，配置多个映射
	public String index(ModelMap map){
		logger.info("这里是controller");
		map.put("title", "hello world");
		return "haha";
	}
}
