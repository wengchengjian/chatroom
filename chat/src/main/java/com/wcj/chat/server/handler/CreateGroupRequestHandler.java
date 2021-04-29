package com.wcj.chat.server.handler;

import com.wcj.chat.entity.Group;
import com.wcj.chat.entity.Message;
import com.wcj.chat.entity.User;
import com.wcj.chat.protocol.Packet.request.CreateGroupRequestPacket;
import com.wcj.chat.protocol.Packet.response.CreateGroupResponsePacket;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.protocol.Packet.response.MessageResponsePacket;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 10:59
 * @Version 1.0.0
 */
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket msg) throws Exception {
            CreateGroupRequestPacket request = msg;

            CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
//
            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            Message message = new Message();
            message.setSourceUsername("服务器");

            Group group= request.getGroup();
            String groupName = group.getName();
            Set<String> users = group.getUsers();

            if(SessionUtils.getGroupMap().containsKey(groupName)){
                message.setMsg("已经存在群聊名称");

                messageResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);
                messageResponsePacket.setMsg(message);
                ctx.channel().writeAndFlush(messageResponsePacket);
                return;
            }

            Set<String> validateUsers = new HashSet<>();
//            可能有部分好友不存在
            StringBuilder str = new StringBuilder();
            for(String user : users){
                if(SessionUtils.getChannel(user)!=null){
                    validateUsers.add(user);
                }else{
                    str.append(user+" ");
                }
            }
//            合法的用户列表
            group.setUsers(validateUsers);

            message.setMsg(str.toString());
            if(!message.getMsg().isEmpty()){
                messageResponsePacket.setMsg(message);
                ctx.channel().writeAndFlush(messageResponsePacket);
            }

            SessionUtils.setGroup(group);
            message.setMsg(SessionUtils.printList(group.getUsers()));
            messageResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);

            createGroupResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);
            createGroupResponsePacket.setGroup(group);
            for(String user: validateUsers){
                SessionUtils.getChannel(user).writeAndFlush(messageResponsePacket);
            }
            ctx.channel().writeAndFlush(createGroupResponsePacket);




    }
}
