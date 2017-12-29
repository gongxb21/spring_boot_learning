package com.gongxb21.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.gongxb21.demo.controller.UserController;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
//这个地方一定要加载启动类
@SpringBootTest(classes=SpringbootDemo25Application.class)
@WebAppConfiguration
public class SpringbootDemo25ApplicationTests {
	@Autowired
	UserController  userController;
	
	MockMvc mvc;
	
	@Autowired
	WebApplicationContext wac;
	
	@Before
	public void init() {
		System.out.println("init method");
		mvc=MockMvcBuilders.webAppContextSetup(wac).build();
		System.out.println("mvc="+mvc);
	}
	
	public void list() {
		System.out.println("list method");
		String str=userController.list();
		Assert.assertEquals("user", str);
		Assert.assertTrue("不一致", str.equals("user"));
		Assert.assertFalse("不一致", str.equals("users"));
	}
	@Test
	//这个地方为什么报404 ，不明白
	public void delete() throws Exception {
		System.out.println("delete method");
		String uri="/get?id=10";
		MvcResult mr=mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_UTF8)).andReturn();
		int status=mr.getResponse().getStatus();
		System.out.println(status+"status");
		String content =mr.getResponse().getContentAsString();
		System.out.println("content="+content);
		Assert.assertTrue("删除成功", status==200);
		Assert.assertFalse("删除失败", status!=200);
		
	}
}
