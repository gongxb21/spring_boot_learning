package com.gongxb21.demo.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author gongxb
 *
 * 2018年1月3日
 */
@Configuration
@EnableScheduling
public class ScheduledTask {
	
	private static final SimpleDateFormat  sdf=new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedDelay=1000)
	public void task1() {
	//	System.out.println("任务1，now is "+sdf.format(new Date()));
	}
	
	@Scheduled(cron="0/2 * *  * * ?")
	public void task2() {
		//System.out.println("任务2，now is "+sdf.format(new Date()));
	}

}
