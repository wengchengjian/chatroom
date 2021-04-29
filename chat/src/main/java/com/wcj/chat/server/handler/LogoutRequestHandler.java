package com.wcj.chat.server.handler;

import com.wcj.chat.protocol.Packet.request.LogoutRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 10:59
 * @Version 1.0.0
 */
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket msg) throws Exception {

    }
}
