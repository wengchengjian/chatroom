package com.wcj.chat.protocol.Packet;

import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.protocol.Packet.command.Command;
import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:33
 * @Version 1.0.0
 */
@Data
public abstract class Packet {

    /**
     * 魔数 唯一标识连接是否正确
     */
    public static final int MAGIC_NUMBER = 0x12345678;

    /**
     * 版本号
     */
    public static Byte version = 1;

    public  Byte SerializerAlgorithm = 1;


    /**
     * 数据指令
     */
    public Command command;
    /**
     * 数据包实际长度
     */
    public int length;
    /**
     * 数据
     */
    public ResponseStatus responseStatus;

    public abstract Command getCommand();

}
