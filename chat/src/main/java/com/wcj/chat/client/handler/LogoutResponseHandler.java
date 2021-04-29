package com.wcj.chat.client.handler;

import com.wcj.chat.protocol.Packet.response.LogoutResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 11:02
 * @Version 1.0.0
 */
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket msg) throws Exception {

    }
}
