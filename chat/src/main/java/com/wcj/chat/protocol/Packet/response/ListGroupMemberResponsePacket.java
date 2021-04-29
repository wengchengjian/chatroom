package com.wcj.chat.protocol.Packet.response;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.command.Command;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 15:22
 * @Version 1.0.0
 */
public class ListGroupMemberResponsePacket extends Packet {
    @Override
    public Command getCommand() {
        return Command.LIST_GROUP_RESPONSE;
    }
}
