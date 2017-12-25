/**
 * Administrator 
 * 下午11:51:35 yy/MM/dd
 */
package com.gongxb21.demo.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author gongxb
 *
 * 2017年12月22日
 */
public class Book {
	private String name; 
	private String prize;
	private String author;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date publishDate;
	
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}


