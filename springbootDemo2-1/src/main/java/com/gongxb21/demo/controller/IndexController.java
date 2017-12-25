package com.gongxb21.demo.controller;




import java.util.Date;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongxb21.demo.bean.Book;

/**
 * @author gongxb
 *
 * 2017年12月23日
 */
@RestController
@RequestMapping("/index")
public class IndexController {
	public static final Logger logger=LoggerFactory.getLogger(IndexController.class);
	@RequestMapping("/index")
	public String index() {
		return "this is a test page ";
	}
	@RequestMapping(value="/getBook")
	public Book getBook() {
		logger.debug("get book method");
		Book book=new Book();
		book.setAuthor("adf");
		book.setName("sdfsa");
		book.setPrize("10$");
		book.setPublishDate(new Date());
		System.out.println(book);
		return book;
	}
}
