package com.gongxb21.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gongxb21.demo.bean.User;
import com.gongxb21.demo.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo25ApplicationTests {
	@Autowired
	UserRepository userRepository;
	public void contextLoads() {
	}
	@Test
	public void save() {
		for(int i=20;i<40;i++) {
			
			System.out.println("22222");
			User user=new  User();
			user.setAge(i);
			user.setName("name"+i);
			userRepository.save(user);
		}
		}
		
	}
