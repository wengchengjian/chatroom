package com.wcj.chat.entity;

import io.netty.channel.Channel;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 11:34
 * @Version 1.0.0
 */
@Data
public class Group {
    private int id;

    private String name;

    private Set<String> users;
}
