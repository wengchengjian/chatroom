package com.wcj.chat.protocol.Packet.response;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.command.Command;
import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 10:53
 * @Version 1.0.0
 */
@Data
public class LogoutResponsePacket extends Packet {
    private String msg;
    @Override
    public Command getCommand() {
        return Command.LOGOUT_RESPONSE;
    }
}
