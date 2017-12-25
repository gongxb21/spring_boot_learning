
package com.gongxb21.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	private Book book; 
	private String bookName; 
	 
	@RequestMapping("/say")
	public String say() {
		System.out.println(book);
		System.out.println(bookName);
		//return book.getName();
		return bookName;
	}
}
