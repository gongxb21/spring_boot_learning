package com.gongxb21.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gongxb21.demo.bean.User;

/**
 * @author gongxb
 *
 * 2017年12月25日
 */

public interface UserRepository  extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User>{
	List<User> findByNameLike(String name);
	
}
