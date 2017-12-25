/**
 * Administrator 
 * 下午8:48:02 yy/MM/dd
 */
package com.gongxb21.demo.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gongxb21.demo.bean.Book;
import com.gongxb21.demo.dao.BookRepository;

/**
 * @author gongxb
 *
 * 2017年12月23日
 */
@RestController
@RequestMapping(value="/book")
public class BookController {
	@Autowired
	BookRepository bookRepository;

	@GetMapping(value="/books")
	/**
	 * 得到书籍列表
	 * @return
	 * List<Book>
	 */
	 public List<Book> BookList(){
		return bookRepository.findAll();
	}
	@GetMapping(value="/addBook")
	/**
	 * 新增书籍
	 * @param name
	 * @param prize
	 * @return
	 * Book
	 */
	public Book addBook(@RequestParam String name,@RequestParam String prize) {
		System.out.println("name="+name);
		System.out.println("prize="+prize);
		Book book=new Book();
		book.setName(name);
		book.setPrize(prize);
		return bookRepository.save(book);
	}
	@GetMapping(value="getBookById/{id}")
	public Book getBookById(@PathVariable Integer id) {
		System.out.println("id="+id);
		return bookRepository.findById(id);
	}
	
	/**
	 * 更新书籍
	 * @param id
	 * @return
	 * Book
	 */
	@GetMapping(value="update")
	public  Book updateBookById(@RequestParam Integer id) {
		Book book=new Book();
		book.setId(id);
		book.setName("up");// 可以从页面上获取
		System.out.println(id);
		return bookRepository.save(book);
	}
	/**
	 * 删除书籍
	 * @param id
	 * void
	 */
	@GetMapping(value="delete")
	public void deleteBook(@RequestParam Integer id) {
		System.out.println("Id="+id);
		Book book=new Book();
		book.setId(id);
		bookRepository.delete(book);
	}
	@GetMapping(value="nameAndPrize")
	public List<Book> findByNameAndPrize(@RequestParam String name,@RequestParam String prize){
		return bookRepository.findByNameAndPrize(name,prize);
	}
	
	@GetMapping("getCount")
	public long getCount() {
		long count=bookRepository.count();
		System.out.println("count="+count);
		return count;
	}
}
