package com.wcj.chat.protocol.Packet.response;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.command.Command;
import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 10:48
 * @Version 1.0.0
 */
@Data
public class JoinGroupResponsePacket extends Packet {
    private String groupName;
    @Override
    public Command getCommand() {
        return Command.JOIN_RESPONSE;
    }
}
