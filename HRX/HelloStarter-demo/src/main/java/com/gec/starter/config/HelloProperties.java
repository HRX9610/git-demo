package com.gec.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "gec.boot")
public class HelloProperties {
    private static final String DEFAULT_NAME = "gec";
    private static final String DEFAULT_MSG = "hello world";
    private String name = DEFAULT_NAME;
    private String msg = DEFAULT_MSG;

    public String getName() {
           return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }


     public void setMsg(String msg) {
        this.msg = msg;
      }
}

