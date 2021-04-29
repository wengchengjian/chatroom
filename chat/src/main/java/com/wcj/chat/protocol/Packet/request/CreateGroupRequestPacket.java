package com.wcj.chat.protocol.Packet.request;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.command.Command;
import com.wcj.chat.entity.Group;
import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 10:47
 * @Version 1.0.0
 */
@Data
public class CreateGroupRequestPacket extends Packet {
    private Group group;

    @Override
    public Command getCommand() {
        return Command.CREATE_REQUEST;
    }
}
