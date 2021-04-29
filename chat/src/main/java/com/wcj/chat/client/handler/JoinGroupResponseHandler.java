package com.wcj.chat.client.handler;

import com.wcj.chat.protocol.Packet.response.JoinGroupResponsePacket;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;
import java.util.Set;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 11:01
 * @Version 1.0.0
 */
public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupResponsePacket msg) throws Exception {
        JoinGroupResponsePacket response = msg;
        String groupName = response.getGroupName();
        System.out.println("成功加入["+groupName+"]");
        Set<String> users = SessionUtils.getGroupMap().get(groupName).getUsers();
        System.out.println(SessionUtils.printList(users));
    }
}
