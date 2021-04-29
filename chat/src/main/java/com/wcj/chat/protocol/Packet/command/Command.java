package com.wcj.chat.protocol.Packet.command;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.response.CreateGroupResponsePacket;
import com.wcj.chat.protocol.Packet.request.CreateGroupRequestPacket;
import com.wcj.chat.protocol.Packet.request.JoinGroupRequestpacket;
import com.wcj.chat.protocol.Packet.request.LoginRequestPacket;
import com.wcj.chat.protocol.Packet.request.MessageRequestPacket;
import com.wcj.chat.protocol.Packet.response.JoinGroupResponsePacket;
import com.wcj.chat.protocol.Packet.response.LoginResponsePacket;
import com.wcj.chat.protocol.Packet.response.MessageResponsePacket;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 15:03
 * @Version 1.0.0
 */
public enum Command {
    /**
     * 登录指令
     */
    LOGIN_REQUEST((byte) 1, LoginRequestPacket.class),
    LOGIN_RESPONSE((byte) 2, LoginResponsePacket.class),

    MESSAGE_REQUEST((byte)3,MessageRequestPacket.class),
    MESSAGE_RESPONSE((byte)4, MessageResponsePacket.class),

    JOIN_REQUEST((byte)5, JoinGroupRequestpacket.class),
    JOIN_RESPONSE((byte)6, JoinGroupResponsePacket.class),

    CREATE_REQUEST((byte)7, CreateGroupRequestPacket.class),
    CREATE_RESPONSE((byte)8, CreateGroupResponsePacket.class),

    LOGOUT_REQUEST((byte) 9, LoginRequestPacket.class),
    LOGOUT_RESPONSE((byte) 10, LoginResponsePacket.class);


    byte id;
    Class< ? extends Packet> packet;
    Command(byte id,Class packet){
        this.id = id;
        this.packet = packet;
    }

    public byte getId(){
        return this.id;
    }
    public Class< ? extends Packet> getPacket(){
        return this.packet;
    }

    public static Class< ? extends Packet> getPacketClass(byte command){
        for(Command command1 : values()){
            if(command1.getId() == command){
                return command1.getPacket();
            }
        }
        return null;
    }
}
