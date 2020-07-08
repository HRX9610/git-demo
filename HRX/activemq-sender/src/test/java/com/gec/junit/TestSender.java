package com.gec.junit;

import com.gec.config.JmsConfig;
import com.gec.service.JmsProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSender {

    @Autowired
    private JmsProducer jmsProducer;

    @Test
    public void testSend(){
        jmsProducer.sendMessage(new ActiveMQTopic(JmsConfig.TOPIC),"来自topic的消息 ！");
       //jmsProducer.sendMessage(new ActiveMQQueue(JmsConfig.QUEUE),"来自Queue的消息 ！");
    }
}
