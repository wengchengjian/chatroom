package com.wcj.chat.server.handler;

import com.wcj.chat.entity.Message;
import com.wcj.chat.protocol.Packet.request.MessageRequestPacket;
import com.wcj.chat.protocol.Packet.response.MessageResponsePacket;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 9:27
 * @Version 1.0.0
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {
        MessageRequestPacket request = msg;

            Message message = request.getMessage();
//            发送发id
            String sourceUsername = message.getSourceUsername();
//            接受方id
            String targetUsername = message.getTargetUsername();
//            接受消息
            String msge = message.getMsg();

            System.out.println(ctx.channel().localAddress()+": 用户["+sourceUsername+"]+----->发送消息给: "+targetUsername+" : " + msge);
//          获取目标Channel
            Channel tagetChannel = SessionUtils.getChannel(targetUsername);
            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();

            messageResponsePacket.setResponseStatus(ResponseStatus.SUCCESS);
            messageResponsePacket.setMsg(message);

            tagetChannel.writeAndFlush(messageResponsePacket);

    }
}
