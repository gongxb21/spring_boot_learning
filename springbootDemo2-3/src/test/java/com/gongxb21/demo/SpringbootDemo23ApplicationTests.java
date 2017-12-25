package com.gongxb21.demo;

import java.sql.Blob;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.gongxb21.demo.bean.Book;
import com.gongxb21.demo.dao.BookRepository;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo23ApplicationTests {
	
	@Autowired
	private BookRepository bookRepository;
	/*@Test
	public void contextLoads() {
	}*/
	public void getCount() {
		long count=bookRepository.count();
		Assert.assertEquals(32, count);;
	}
	public void countByName() {
		
		long count=bookRepository.countByName("name1");
		System.out.println("count="+count);
	}
	public void findByNameLikeOrderByIdDesc() {
		
		List<Book> books=bookRepository.findByNameLikeOrderByIdDesc("name1%");
		System.out.println("count like="+books);
	}
	public void findByIdBetween() {
		List<Book> books=bookRepository.findByIdBetween(10,15);
		System.out.println(books);
	}
	public void findByIdLessThan() {
		List<Book> books=bookRepository.findByIdLessThan(3);
		System.out.println(books);
	}
	
	public void findByIdIn() {
		List<Book> books=bookRepository.findByIdIn(1,20);
		System.out.println(books);
	}
	public void fingByNameIsNull() {
		//这个方法的sql是没错的，但是为什么在数据库中执行是查不到数据的
		List<Book> books=bookRepository.findByNameIsNull();
		System.out.println(books);
	}
	public void fingByNameIsNotNull() {
		List<Book> books=bookRepository.findByNameIsNotNull();
		System.out.println(books);
	}
	@Test
	public void pageQuery() {
		int page=2;
		int size=10;
		Sort sort = new Sort(Direction.DESC, "id");
	    Pageable pageable = new PageRequest(page, size, sort);
	   Page<Book> books= bookRepository.findAll(pageable);
	   
	   System.out.println(books.getContent());
	}
}
