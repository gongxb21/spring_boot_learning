/**
 * Administrator 
 * 下午6:12:04 yy/MM/dd
 */
package com.gongxb21.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gongxb
 *
 * 2017年12月23日
 */
@Entity
@Table(name="booknew")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id; 
	} 
	private String name; 
	private String prize;
	private String author;
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
	@Override
	public String toString() {
		return "Booknew [id=" + id + ", name=" + name + ", prize=" + prize + ", author=" + author + "]";
	}
	/**
	 * 
	 */
	public Book() {
		super();
	}
	
}
