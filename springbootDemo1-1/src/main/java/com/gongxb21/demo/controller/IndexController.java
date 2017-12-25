
package com.gongxb21.demo.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gongxb21.demo.bean.Book;




/**
 * @author gongxb
 *
 * 2017年12月22日
 */
@RestController
@RequestMapping(value="/index")
public class IndexController {
	@RequestMapping
	public String index() {
		//访问的方式是localhost/index.index
		return "HelloWorld!";
	}
	@RequestMapping(value = "/get")
	public HashMap<String, Object> get(@RequestParam String name) {
		//访问的方式是localhost:port/index/get?name=aaa
		System.out.println("haha"+name);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		return map;
	}
	@RequestMapping(value = "/get/{id}/{name}")
	public Book getUser(@PathVariable String author, @PathVariable String name) {
		//访问的方式是localhost/index/get/1/2
		System.out.println("autuor="+author);
		System.out.println("name="+name);
		Book book = new Book();
		book.setAuthor("aut");
		book.setName("aaa");
		book.setPrize("1");
		return book;
	}
}
