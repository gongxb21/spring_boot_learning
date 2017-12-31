package com.gongxb21.demo.configration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author gongxb
 *
 * 2017年12月31日
 */
@Configuration
public class CorsConfigration extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		System.out.println(" cors add corsMapping method");
		registry.addMapping("/corsController/**").allowedOrigins("http://localhost:8080");
	}

}
