/**
 * Administrator 
 * 下午9:46:47 yy/MM/dd
 */
package com.gongxb21.demo.bean;

import java.util.Date;

/**
 * @author gongxb
 *
 * 2017年12月22日
 */
public class Book {
	private String name;
	private String prize;
	private String author;
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

