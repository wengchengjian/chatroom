package com.wcj.chat.client.handler;

import com.wcj.chat.entity.Group;
import com.wcj.chat.protocol.Packet.response.CreateGroupResponsePacket;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 11:01
 * @Version 1.0.0
 */
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupResponsePacket msg) throws Exception {
            CreateGroupResponsePacket response = msg;


                if(response.getResponseStatus()== ResponseStatus.SUCCESS){
                    Group group = response.getGroup();
                    System.out.println("创建群聊:["+group.getName()+"]成功");
                    System.out.println(SessionUtils.printList(group.getUsers()));
                }


    }

}
