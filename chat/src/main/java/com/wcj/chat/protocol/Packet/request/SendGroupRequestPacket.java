package com.wcj.chat.protocol.Packet.request;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.command.Command;
import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 18:21
 * @Version 1.0.0
 */
@Data
public class SendGroupRequestPacket extends Packet {
    private String groupName;

    private String messgae;

    @Override
    public Command getCommand() {
        return Command.SEND_GROUP_REQUEST;
    }
}
