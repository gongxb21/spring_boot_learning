package com.gongxb21.demo.producer;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author gongxb
 *
 * 2018年1月6日
 */
@Service("producer")
public class MyJMSProducer {
	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	public void sendMsg(Destination des,String message) {
		jmsTemplate.convertAndSend(des, message);
		
	}
}
