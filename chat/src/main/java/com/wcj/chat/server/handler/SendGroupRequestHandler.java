package com.wcj.chat.server.handler;

import com.wcj.chat.entity.Message;
import com.wcj.chat.entity.User;
import com.wcj.chat.enums.AttributeKeyEnums;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.protocol.Packet.request.SendGroupRequestPacket;
import com.wcj.chat.protocol.Packet.response.MessageResponsePacket;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Set;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 18:20
 * @Version 1.0.0
 */
public class SendGroupRequestHandler extends SimpleChannelInboundHandler<SendGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SendGroupRequestPacket packet) throws Exception {
        SendGroupRequestPacket request = packet;
        String groupName = request.getGroupName();
        String message =  request.getMessgae();
        User user = ctx.channel().attr(AttributeKeyEnums.SESSION).get();
        Set<String> users = SessionUtils.getGroupMap().get(groupName).getUsers();


        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        Message messages = new Message();
        messages.setSourceUsername(groupName+": "+user.getUsername());
        if(users.contains(user.getUsername())){

            for(String username: users){

                Channel channel = SessionUtils.getChannel(username);

                messages.setMsg(message);
                messageResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);
                messageResponsePacket.setMsg(messages);

                channel.writeAndFlush(messageResponsePacket);

            }
        }else{
            messages.setSourceUsername("服务器");
            messages.setMsg("你没有加入到["+groupName+"]中,无法开启聊天");
            messageResponsePacket.setMsg(messages);
            messageResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);
            ctx.writeAndFlush(messageResponsePacket);
        }
    }
}
