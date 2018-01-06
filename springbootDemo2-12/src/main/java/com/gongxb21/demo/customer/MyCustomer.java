package com.gongxb21.demo.customer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author gongxb
 *
 * 2018年1月6日
 */
@Component
public class MyCustomer {
	@JmsListener(destination="myjms.queue")
	public void receiveMsg(String message) {
		System.out.println("the message I receive is:"+message);
	}
	@JmsListener(destination="foo.bar")
	public void receiveMsg2(String message) {
		System.out.println("the message I receive is:"+message);
	}
}
