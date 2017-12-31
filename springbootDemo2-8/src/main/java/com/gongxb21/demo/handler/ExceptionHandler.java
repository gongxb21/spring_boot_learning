package com.gongxb21.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author gongxb
 *
 * 2017年12月31日
 */

@ControllerAdvice
public class ExceptionHandler {
	private static final Logger logger=LoggerFactory.getLogger(ExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
	public ModelAndView handlerRuntimeException(RuntimeException re) {
		logger.info("handle runtime exception");
		ModelAndView mav=new ModelAndView();
		mav.setStatus(HttpStatus.OK);
		mav.addObject("exception", re.getMessage());
		mav.setViewName("error/500");
		logger.info("adasf");
		return mav;
	}
	@org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
	public ModelAndView handlerException(Exception re) {
		logger.info("handle exception");
		ModelAndView mav=new ModelAndView();
		mav.setStatus(HttpStatus.OK);
		mav.addObject("exception", re.getMessage());
		mav.setViewName("error/500");
		return mav;
	}
}
