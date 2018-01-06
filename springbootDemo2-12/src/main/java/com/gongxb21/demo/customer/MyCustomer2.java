package com.gongxb21.demo.customer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author gongxb
 *
 * 2018年1月6日
 */
@Component
public class MyCustomer2 {
	@JmsListener(destination="myjms2.queue")
	@SendTo(value="out.queue")
	public String receiveMsg(String message) {
		System.out.println("the message I receive is:"+message);
		return " return  message  is:"+message;
	}
}
