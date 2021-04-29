package com.wcj.chat.enums;

import com.wcj.chat.entity.User;
import io.netty.util.AttributeKey;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 8:56
 * @Version 1.0.0
 */
public interface AttributeKeyEnums {
    public static final AttributeKey<User> SESSION= AttributeKey.newInstance("session");
}
