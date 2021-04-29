package com.wcj.chat.client.handler;

import com.wcj.chat.entity.Message;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.protocol.Packet.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 9:29
 * @Version 1.0.0
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) throws Exception {
        MessageResponsePacket response = msg;
        if(response!=null) {
            if (response.getResponseStatus() == ResponseStatus.SUCCESS) {
                Message message = response.getMsg();

                String mesge = message.getMsg();

                String username = message.getSourceUsername();

                System.out.println("用户[" + username + "]" + "--->发来消息: " + mesge);
            }
        }else{

        }
    }
}
