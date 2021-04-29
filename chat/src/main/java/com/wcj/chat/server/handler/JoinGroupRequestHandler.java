package com.wcj.chat.server.handler;

import com.wcj.chat.entity.Group;
import com.wcj.chat.entity.Message;
import com.wcj.chat.enums.AttributeKeyEnums;
import com.wcj.chat.protocol.Packet.request.JoinGroupRequestpacket;
import com.wcj.chat.protocol.Packet.response.JoinGroupResponsePacket;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.protocol.Packet.response.MessageResponsePacket;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;
import java.util.Set;

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
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);

        Message message = new Message();
        message.setSourceUsername("服务器");



        if(group==null){
            messageResponsePacket.setMsg(message);
            ctx.channel().writeAndFlush(messageResponsePacket);
            return;
        }
        Set<String> users= group.getUsers();
        String username =ctx.channel().attr(AttributeKeyEnums.SESSION).get().getUsername();

        users.add(username);

        message.setMsg(SessionUtils.printList(users));

        messageResponsePacket.setMsg(message);

        ctx.channel().writeAndFlush(messageResponsePacket);

    }
}
