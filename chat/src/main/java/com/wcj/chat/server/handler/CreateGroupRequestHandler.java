package com.wcj.chat.server.handler;

import com.wcj.chat.entity.Group;
import com.wcj.chat.protocol.Packet.request.CreateGroupRequestPacket;
import com.wcj.chat.protocol.Packet.response.CreateGroupResponsePacket;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 10:59
 * @Version 1.0.0
 */
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket msg) throws Exception {
        CreateGroupRequestPacket request = msg;


            Group group= request.getGroup();

            SessionUtils.setGroup(group);

            CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();

            createGroupResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);
            createGroupResponsePacket.setGroup(group);
            ctx.channel().writeAndFlush(createGroupResponsePacket);



    }
}
