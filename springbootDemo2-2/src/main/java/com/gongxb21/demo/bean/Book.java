/**
 * Administrator 
 * 下午1:21:34 yy/MM/dd
 */
package com.gongxb21.demo.bean;

/**
 * @author gongxb
 *
 * 2017年12月23日
 */
public class Book {
	private String name;
	private String prize;
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
	@Override
	public String toString() {
		return "Book [name=" + name + ", prize=" + prize + "]";
	}
	
}
