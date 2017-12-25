package com.gongxb21.demo.controller;
/**
 * Administrator 
 * 下午9:48:20 yy/MM/dd
 */

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	//在json 文件中定义，在run Configuration 中赋值
	@Value(value="${book.prize}")
	private String prize;
	
	@Value(value="${book.name}")
	private String name;
	
	@Value(value="${book.author}")
	private String author;
	
	
	@RequestMapping(value="/index")
	public String index() {
		System.out.println("sdfsafd");
		return "helloWorlds!";
	}
	
	// @PathVariable 获得请求url中的动态参数
	@RequestMapping(value="/getMap/{name}/{author}")
	public HashMap<String,Object> getMap(@PathVariable String name,@PathVariable String author){
		System.out.println("name "+name);
		System.out.println("author "+author);
		HashMap<String,Object> hm=new HashMap<String,Object>();
		Book book =new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setPrize(prize);
		hm.put("book", book);
		return hm;
	}
	@RequestMapping(value="/getBook")
	public Book getBook() {
		Book book=new Book();
		book.setAuthor(author);
		book.setName(name);
		book.setPrize(prize);
		book.setPublishDate(new Date()); 
		System.out.println("publishDate"+book.getPublishDate());
		return book;
	}
}

