package com.gongxb21.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author gongxb
 *
 * 2017年12月31日
 */
@WebListener
public class MyWebListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println(" context desotroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println( " context initialized");
	}
	
}
