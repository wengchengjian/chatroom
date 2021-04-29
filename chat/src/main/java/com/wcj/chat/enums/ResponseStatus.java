package com.wcj.chat.enums;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 15:40
 * @Version 1.0.0
 */
public enum ResponseStatus {

    /**
     *
     */
    SUCCESS(200,"响应成功"),
    FAILED(201,"响应失败");

    int code;
    String msg;

    ResponseStatus(int code,String msg){
        this.code = code;
        this.msg =msg;
    }
    public String getMsg(){
        return this.msg;
    }

    public int getCode(){
        return this.code;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
}
