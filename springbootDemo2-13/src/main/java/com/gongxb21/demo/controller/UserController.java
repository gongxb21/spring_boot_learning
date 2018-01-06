package com.gongxb21.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gongxb21.demo.jpa.bean.User;
import com.gongxb21.demo.jpa.repository.UserRepository;
import com.gongxb21.demo.util.ExcelData;
import com.gongxb21.demo.util.ExportExcelUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author gongxb
 *
 * 2018年1月6日
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger =LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/downloadpdf")
	public void download(HttpServletRequest request,HttpServletResponse reponse) throws Exception {
		logger.info("down load method");
		reponse.setHeader("content-Type", "application/pdf");
		reponse.setHeader("content-Disposition", "attachment;filename=user.pdf");
		Document doc=new Document();
		PdfWriter.getInstance(doc, reponse.getOutputStream());
		doc.open();
		List<User> list=userRepository.findByIdLessThan(20);
		logger.info("the list size is"+list.size());
		//doc.add(new Paragraph("hello world"));
		for(User user :list) {  
			logger.info("userId="+user.getId());
			PdfPTable table=new PdfPTable(3);
			PdfPCell cell=new PdfPCell();
			cell.setPhrase(new Paragraph(String.valueOf(user.getId())));
			table.addCell(cell);
			doc.add(table);
			
			cell=new PdfPCell();
			cell.setPhrase(new Paragraph(user.getName()));
			table.addCell(cell);
			doc.add(table);
			
			cell=new PdfPCell();
			cell.setPhrase(new Paragraph(String.valueOf(user.getAge())));
			table.addCell(cell);
			doc.add(table);
		}
		doc.close();
	}
	
	@RequestMapping("/downloadExcel")
	public void downloadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
		logger.info(" download excel method");
		List<User> list=userRepository.findByIdLessThan(30);
		List<Object> row;
		List<List<Object>> rows =new ArrayList<List<Object>>();
		ExcelData data=new ExcelData();
		List<String> titleList =new ArrayList<String>();
		titleList.add("序号");
		titleList.add("姓名");
		titleList.add("年龄");
		data.setName("user");
		data.setTitleList(titleList);
		for(User user:list) {
			row=new ArrayList<Object>();
			row.add(String.valueOf(user.getId()));
			row.add(String.valueOf(user.getName()));
			row.add(String.valueOf(user.getAge()));
			rows.add(row);
		}
		data.setRows(rows);
		String fileName="user.xls";
		ExportExcelUtil.exportExcel(request, response, fileName, data);
		
	}
}
