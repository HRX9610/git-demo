package com.gec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

public class JmsConfig {

    public final static String TOPIC = "springboot.topic.test";
    public final static String QUEUE = "springboot.queue.test";

}
