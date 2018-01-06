package com.gongxb21.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gongxb21.demo.jpa.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo213ApplicationTests {
	@Autowired
	private UserRepository userRepository;
	

	public void findAll() {
		List list=userRepository.findAll();
		System.out.println(list);
	}
	@Test
	public void findByIdLessThan() {
		List list=userRepository.findByIdLessThan(20);
		System.out.println(list);
	}

}
