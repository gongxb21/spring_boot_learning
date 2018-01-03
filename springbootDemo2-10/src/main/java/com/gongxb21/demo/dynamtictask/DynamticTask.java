package com.gongxb21.demo.dynamtictask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * @author gongxb
 *
 * 2018年1月3日
 */
//@Component
@Configuration 
//这个注解和component 注解类似
@EnableScheduling
public class DynamticTask implements SchedulingConfigurer{
	
	private String cronExpression;
	public String getCronExpression() {
		return cronExpression; 
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	private static final SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
	private static final  String cronDefaultExpression="0/4 * * * * ?";
	
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		 Runnable task = new Runnable() {
	           @Override
	           public void run() {
	        	   if(cronExpression!=null&&!cronExpression.equals(cronDefaultExpression)) {
	        		   System.out.println("TaskCronChange task is running ... "+ sdf.format(new Date()));
	        	   }else {
	        		   System.out.println("dfsdf+"+sdf.format(new Date()));
	        	   }
	        	   //任务逻辑代码部分.
	        	  
	           }
	       };
	       Trigger trigger = new Trigger() {
	           @Override
	           public Date nextExecutionTime(TriggerContext triggerContext) {
	              
	        	   
	        	   //任务触发，可修改任务的执行周期.
	        	   CronTrigger trigger =null;
	        	   if(cronExpression!=null) {
	        		   trigger = new CronTrigger(cronExpression);
	        	   }else {
	        		    trigger = new CronTrigger(cronDefaultExpression);
	        	   }
	              Date nextExec = trigger.nextExecutionTime(triggerContext);
	              return nextExec;
	           }

	       };
		
		scheduledTaskRegistrar.addTriggerTask(task, trigger);
	
	} 
	

	

}
