package com.gongxb21.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpringbootDemo28Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo28Application.class, args);
	}
}
