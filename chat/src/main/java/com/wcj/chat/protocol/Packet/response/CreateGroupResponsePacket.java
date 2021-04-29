package com.wcj.chat.protocol.Packet.response;

import com.wcj.chat.entity.Group;
import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.command.Command;
import lombok.Data;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 10:47
 * @Version 1.0.0
 */
@Data
public class CreateGroupResponsePacket extends Packet {
    public Group group;
    @Override
    public Command getCommand() {
        return Command.CREATE_RESPONSE;
    }
}
