package com.gongxb21.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo210ApplicationTests {
	@Autowired
	private JavaMailSender  jms;
	
	@Value("${spring.mail.username}")
	private String userName;
	
	@Test
	public void sendMail() {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom(userName);
		message.setTo("1031421854@qq.com");
		message.setSubject("this is a spring boot mail test");
		message.setText("helloword !!!");
		jms.send(message);
	}
}
