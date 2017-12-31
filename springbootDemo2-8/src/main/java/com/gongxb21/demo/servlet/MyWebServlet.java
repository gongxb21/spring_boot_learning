package com.gongxb21.demo.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @author gongxb
 *
 * 2017年12月31日
 */
@WebServlet(urlPatterns="/myWeb" ,name="myWebServlet")
public class MyWebServlet  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet get method");
		doPost(request, response);
	}

	/*@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("servlet post method");
		response.getWriter().write("hello world");
	}*/
}
