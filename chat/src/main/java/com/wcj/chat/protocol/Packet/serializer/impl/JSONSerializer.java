package com.wcj.chat.protocol.Packet.serializer.impl;


import com.alibaba.fastjson.JSON;
import com.wcj.chat.protocol.Packet.serializer.Serializer;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:44
 * @Version 1.0.0
 */
public class JSONSerializer implements Serializer {
    private static final byte ALGORITHM_ID = 1;

    public  static final JSONSerializer INSTANCE = new JSONSerializer();


    private JSONSerializer(){

    }

    @Override
    public byte getSerializerAlgorithm() {
        return ALGORITHM_ID;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes,clazz);
    }


}
