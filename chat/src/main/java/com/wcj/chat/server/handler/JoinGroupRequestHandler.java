package com.wcj.chat.server.handler;

import com.wcj.chat.entity.Group;
import com.wcj.chat.protocol.Packet.request.JoinGroupRequestpacket;
import com.wcj.chat.protocol.Packet.response.JoinGroupResponsePacket;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 11:00
 * @Version 1.0.0
 */
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestpacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestpacket msg) throws Exception {
        JoinGroupRequestpacket request = msg;
        String groupName = request.getGroupName();
        Group group= SessionUtils.getGroupMap().get(groupName);
        List<Channel> channels= group.getUsers();
        channels.add(ctx.channel());

        JoinGroupResponsePacket joinGroupResponsePacket = new JoinGroupResponsePacket();
        joinGroupResponsePacket.setGroupName(groupName);
        joinGroupResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);

        ctx.channel().writeAndFlush(joinGroupResponsePacket);

    }
}
