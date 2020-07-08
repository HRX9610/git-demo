package com.gec.starter.service;

public class HelloService {
  private String name;
  private String msg;
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

   //核心业务方法
   public String sayHello() {
        return this.name +" 说："+this.msg;
    }
}
