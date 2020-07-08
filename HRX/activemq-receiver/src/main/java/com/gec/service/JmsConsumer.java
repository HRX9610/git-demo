package com.gec.service;

import com.gec.config.JmsConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component //@Service
public class JmsConsumer {

    @JmsListener(destination = JmsConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
    public void onTopicMessage1(String text){
        System.out.println("topic的消息接收1："+ text);
    }

    @JmsListener(destination = JmsConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
    public void onTopicMessage2(Message message){
        TextMessage textMsg = (TextMessage) message;
        try {
            String text =  textMsg.getText();
            System.out.println("topic的消息接收2："+ text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @JmsListener(destination = JmsConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage1(String text){
        System.out.println("Queue的消息接收1："+ text);
    }

    @JmsListener(destination = JmsConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage2(String text){
        System.out.println("Queue的消息接收2："+ text);
    }
}
