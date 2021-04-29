package com.wcj.chat.protocol.Packet.response;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.command.Command;
import com.wcj.chat.entity.Message;
import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 9:24
 * @Version 1.0.0
 */
@Data
public class MessageResponsePacket extends Packet {
    private Message msg;

    @Override
    public Command getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
