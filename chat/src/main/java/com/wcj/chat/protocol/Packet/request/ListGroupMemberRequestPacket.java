package com.wcj.chat.protocol.Packet.request;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.command.Command;
import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 15:21
 * @Version 1.0.0
 */
@Data
public class ListGroupMemberRequestPacket extends Packet {
    private String groupName;

    @Override
    public Command getCommand() {
        return Command.LIST_GROUP_REQUEST;
    }
}
