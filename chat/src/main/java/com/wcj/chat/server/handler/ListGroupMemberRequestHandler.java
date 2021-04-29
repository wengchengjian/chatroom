package com.wcj.chat.server.handler;

import com.wcj.chat.entity.Group;
import com.wcj.chat.entity.Message;
import com.wcj.chat.entity.User;
import com.wcj.chat.enums.AttributeKeyEnums;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.protocol.Packet.request.ListGroupMemberRequestPacket;
import com.wcj.chat.protocol.Packet.response.MessageResponsePacket;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Set;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 15:25
 * @Version 1.0.0
 */
public class ListGroupMemberRequestHandler extends SimpleChannelInboundHandler<ListGroupMemberRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMemberRequestPacket listGroupMemberRequestPacket) throws Exception {
        ListGroupMemberRequestPacket  request = listGroupMemberRequestPacket;
        String groupName = request.getGroupName();
        User user = ctx.channel().attr(AttributeKeyEnums.SESSION).get();


        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        Message message = new Message();
        message.setSourceUsername("服务器");
        Group group = SessionUtils.getGroupMap().get(groupName);
        if(group==null){
            message.setMsg("没有这个群聊");
            messageResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);
            messageResponsePacket.setMsg(message);
            ctx.channel().writeAndFlush(message);
            return;
        }
        Set<String> users  = group.getUsers();
        if(users.contains(user.getUsername())){
            message.setMsg(SessionUtils.printList(users));
        }else{
            message.setMsg("你并不在["+groupName+"]中,不能获取其中的信息");
        }


        messageResponsePacket.setMsg(message);
        messageResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);
        ctx.writeAndFlush(messageResponsePacket);

    }
}
