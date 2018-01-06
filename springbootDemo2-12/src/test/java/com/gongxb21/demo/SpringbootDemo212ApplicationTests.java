package com.gongxb21.demo;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gongxb21.demo.producer.MyJMSProducer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo212ApplicationTests {
	@Autowired
	private MyJMSProducer myJmsProducer;
	
	@Test
	public void sendMessageTest() {
		Destination des=new ActiveMQQueue("myjms.queue");
		for (int i=0;i<1;i++) {
			myJmsProducer.sendMsg(des, "send Jms Message"+i);
		}
	}
	@Test
	public void sendMessageTest2() {
		Destination des=new ActiveMQQueue("myjms2.queue");
		for (int i=0;i<100;i++) {
			myJmsProducer.sendMsg(des, "send Jms Message"+i);
		}
	}

}
