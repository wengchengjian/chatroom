package com.wcj.chat.protocol.Packet.request;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.command.Command;
import com.wcj.chat.entity.User;
import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:32
 * @Version 1.0.0
 */
@Data
public class LoginRequestPacket extends Packet {
    private User user;

    public LoginRequestPacket(User user){
        this.user= user;
    }

    public LoginRequestPacket(){

    }


    @Override
    public Command getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
