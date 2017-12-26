package com.gongxb21.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gongxb21.demo.bean.User;
import com.gongxb21.demo.exception.MyException;
import com.gongxb21.demo.json.AjaxResult;
import com.gongxb21.demo.repository.UserRepository;
import com.gongxb21.demo.service.UserService;

/**
 * @author gongxb
 *
 * 2017年12月25日
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
	Logger logger =LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserRepository userRepository ;
	@Autowired
	private UserService userService;
	@RequestMapping(value="/index")
	public String index() {
		logger.info("index method");
		return "index";
	}
	
	@RequestMapping(value="/list")
	public String list() {
		logger.info(" list method");
		return "user";
	}
	
	 // 把spring data的page进行转换，变成easyui需要的数据
	  public <T> Map<String, Object> findEasyUIData(Page<T> page) {
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("rows", page.getContent());
	    map.put("total", page.getTotalElements());
	    return map;
	  }
	  
	// 从user.jsp列表页面由easyui-datagrid发出ajax请求获取json数据
	  @RequestMapping("/json")
	  @ResponseBody
	  public Map<String, Object> json(@RequestParam(name = "page", defaultValue = "1") int page,
	      @RequestParam(name = "rows", defaultValue = "10") int rows, final String q) {
	    // 按照id降序
	    Sort sort = new Sort(Sort.Direction.DESC, "id");
	    // 封装分页查询条件
	    Pageable pageable = new PageRequest(page - 1, rows, sort);
	    if (!StringUtils.isEmpty(q)) {
	      // 拼接查询条件
	      Specification<User> specification = new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			  List<Predicate> list = new ArrayList<Predicate>();
			  list.add(cb.like(root.get("name").as(String.class), "%" + q + "%"));
			  Predicate[] p = new Predicate[list.size()];
			  return cb.and(list.toArray(p));
	
			}
	      };
	      return findEasyUIData(userRepository.findAll(specification,pageable));
	    } else {
	      return findEasyUIData(userRepository.findAll(pageable));
	    }
	  }
	  
	  // 处理保存
	  @RequestMapping("/save")
	  @ResponseBody
	  public AjaxResult save(@Valid User user,BindingResult bindingResult) {
		  if(bindingResult.hasErrors()) {
			  logger.info(bindingResult.getFieldError().getDefaultMessage());
		  }
	    return new AjaxResult().success(userRepository.save(user));
	  }

	  // 处理删除
	  @RequestMapping("/delete/{id}")
	  @ResponseBody
	  public AjaxResult delete(@PathVariable int id) {
		  logger.info("id={}",id);
	    int a = 1 / 0;
	    userRepository.delete(id);
	    return new AjaxResult().success();
	  }
	  
	  @RequestMapping("/get/{id}")
	  @ResponseBody
	  public AjaxResult getUser(@PathVariable int id) throws MyException {
		  logger.info("id={}",id);
		 User user= userService.getUser(id);
		 AjaxResult ar=new AjaxResult();
		 return ar.success(user);
	  }
}
