package com.wcj.chat.entity;

import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 9:32
 * @Version 1.0.0
 */
@Data
public class Message {
    private int id;

    private String sourceUsername;

    private String targetUsername;

    private String msg;
}
