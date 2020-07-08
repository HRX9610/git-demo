package com.gec.security.pojo;

public class RespBean {

    private Integer status;  //状态码 200  500
    private String msg;  //提示消息
    private Object obj; // 返回的数据

    public RespBean() {
    }

    public static RespBean ok(String msg){
        return new RespBean(200,msg);
    }
    public static RespBean ok(String msg,Object obj){
        return new RespBean(200,msg,obj);
    }

    public static RespBean error(String msg){
        return new RespBean(200,msg);
    }
    public static RespBean error(String msg,Object obj){
        return new RespBean(200,msg,obj);
    }
    private RespBean(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    private RespBean(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
