/**
 * Administrator 
 * 下午8:52:16 yy/MM/dd
 */
package com.gongxb21.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gongxb21.demo.bean.Book;

/**
 * @author gongxb
 *
 * 2017年12月23日
 */

public interface BookRepository extends JpaRepository<Book, String> {


	/**
	 * @param id
	 * @return
	 * Book
	 */
	Book findById(Integer id);

	/**
	 * @param name
	 * @param prize
	 * @return
	 * List<Book>
	 */
	List<Book> findByNameAndPrize(String name, String prize);

	/**
	 * @param string
	 * void
	 */
	long countByName(String string);

	/**
	 * @param string
	 * @return
	 * long
	 */
	long countByNameLike(String string);

	/**
	 * @param i
	 * @param j
	 * void
	 */
	List<Book> findByIdBetween(int i, int j);

	/**
	 * @param i
	 * @return
	 * List<Book>
	 */
	List<Book> findByIdLessThan(int i);

	/**
	 * @param i
	 * @param j
	 * @return
	 * List<Book>
	 */
	List<Book> findByIdIn(int ... i);

	/**
	 * @return
	 * List<Book>
	 */
	List<Book> findByNameIsNull();

	/**
	 * @return
	 * List<Book>
	 */
	List<Book> findByNameIsNotNull();


	/**
	 * @param string
	 * @return
	 * List<Book>
	 */
	List<Book> findByNameLikeOrderByIdDesc(String string);


}
