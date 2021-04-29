package com.wcj.chat.enums;

import com.wcj.chat.protocol.Packet.serializer.Serializer;
import com.wcj.chat.protocol.Packet.serializer.impl.JSONSerializer;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:46
 * @Version 1.0.0
 */
public enum SerializerAlgorithm {
    /**
     *
     */
    JSON((byte) 1, JSONSerializer.INSTANCE);



    byte code;
    Serializer serializer;

    SerializerAlgorithm(byte code,Serializer serializer){
        this.code = code;
        this.serializer = serializer;
    }

    public Serializer getSerializer() {
        return serializer;
    }

    public byte getCode() {
        return code;
    }

    public static Serializer getStaticSerializer(byte code){
        for(SerializerAlgorithm serializerAlgorithm : values()){
            if(serializerAlgorithm.getCode() ==code){
                return serializerAlgorithm.getSerializer();
            }
        }
        return  null;
    }
}
