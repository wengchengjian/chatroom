package com.wcj.chat.protocol.Packet.handler;

import com.wcj.chat.protocol.Packet.Packet;
import com.wcj.chat.protocol.Packet.PacketCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class PacketDecoder extends MessageToMessageDecoder<ByteBuf> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) {
        Packet p = PacketCodec.INSTANCE.decode(in);
        out.add(p);
    }
}
