package com.wcj.chat.protocol.Packet.serializer;


import com.wcj.chat.protocol.Packet.serializer.impl.JSONSerializer;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:42
 * @Version 1.0.0
 */
public interface Serializer {
    Serializer DEFAULT = JSONSerializer.INSTANCE;
    /**
     * 序列化算法
     * @return
     */
    byte getSerializerAlgorithm();

    /**
     * java 对象转换成二进制
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换成 java 对象
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
