package com.gongxb21.demo.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author gongxb
 *
 * 2018年1月6日
 */
public class ExcelData implements Serializable{
	private List<String> titleList;
	private List<List<Object>> rows;
	private String name;
	
	public List<String> getTitleList() {
		return titleList;
	}
	public void setTitleList(List<String> titleList) {
		this.titleList = titleList;
	}
	public List<List<Object>> getRows() {
		return rows;
	}
	public void setRows(List<List<Object>> rows) {
		this.rows = rows;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
