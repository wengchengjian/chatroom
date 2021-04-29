package com.wcj.chat.protocol.Packet.handler;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 16:37
 * @Version 1.0.0
 */
@ChannelHandler.Sharable
public class PacketCodecHandler extends MessageToMessageCodec<ByteBuf, Packet> {
    public static final PacketCodecHandler INSTANCE = new PacketCodecHandler();

    public  PacketCodecHandler() {

    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) {

        out.add(PacketCodec.decode(byteBuf));

    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, List<Object> out) {
        ByteBuf byteBuf = ctx.channel().alloc().ioBuffer();

        PacketCodec.encode(byteBuf, packet);
        out.add(byteBuf);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }
}