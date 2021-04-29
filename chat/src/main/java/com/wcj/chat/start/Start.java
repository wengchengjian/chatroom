package com.wcj.chat.start;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:18
 * @Version 1.0.0
 */
public interface Start {
    int DEFAULT_SERVER_PORT  =8000;


    String DEFAULT_SERVER_HOST = "127.0.0.1";

    /**
     * 客户端和服务端的启动类的基类
     * @throws Exception
     */
    void start() throws Exception;
}
