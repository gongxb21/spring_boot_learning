package com.gongxb21.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gongxb21.demo.bean.MyExceptionEnum;
import com.gongxb21.demo.bean.User;
import com.gongxb21.demo.exception.MyException;
import com.gongxb21.demo.repository.UserRepository;

/**
 * @author gongxb
 *
 * 2017年12月26日
 */
@Component
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User getUser(Integer id) throws MyException {
		User user= userRepository.findOne(id);
		if(user.getAge()<15) {
			throw new MyException(MyExceptionEnum.CHILD_ERROR);
		}else if(user.getAge()<30) {
			throw new MyException(MyExceptionEnum.ADULT_ERROR);
		}
		return user;
	}
}
