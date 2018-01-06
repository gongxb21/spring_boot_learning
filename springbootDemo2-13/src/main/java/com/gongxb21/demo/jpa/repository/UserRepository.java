package com.gongxb21.demo.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gongxb21.demo.jpa.bean.User;

/**
 * @author gongxb
 *
 * 2018年1月6日
 */
public interface UserRepository extends JpaRepository<User,String> {

	/**
	 * @param i
	 * @return
	 * List<User>
	 */
	List<User> findByIdLessThan(int i);

}
