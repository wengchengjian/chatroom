package com.wcj.chat.protocol.Packet.response;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.command.Command;
import com.wcj.chat.entity.User;
import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:33
 * @Version 1.0.0
 */
@Data
public class LoginResponsePacket extends Packet {
    private User user;
    public LoginResponsePacket( User user){
        this.user = user;
    }
    public LoginResponsePacket(){

    }

    @Override
    public Command getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
