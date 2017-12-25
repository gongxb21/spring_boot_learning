package com.gongxb21.demo.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

/**
 * @author gongxb
 *
 * 2017年12月25日
 */
@Aspect
@Component
public class UserAspect {
	private static final Logger logger=LoggerFactory.getLogger(UserAspect.class);
	
	@Pointcut("execution(* com.gongxb21.demo.repository.*.*(..))")
	public void log() {
	}
	@After("log()")
	public void doAfter() {
		logger.info("after");
	}
	@Before("log()")
	public void doBefore(JoinPoint jp) {
		ServletRequestAttributes attribute=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request= attribute.getRequest();
		logger.info("url={}",request.getRequestURI());
		logger.info("method={}", request.getMethod());
		logger.info("ip={}", request.getRemoteAddr());
		logger.info("method={}",jp.getSignature().getDeclaringTypeName()+"."+jp.getSignature().getName());
		logger.info("args={}",jp.getArgs());
	}
	@AfterReturning(returning="obj",pointcut="log()")
	public void doAfterReturning(Object obj) {
		logger.info("repose={}",obj);
	}
}
