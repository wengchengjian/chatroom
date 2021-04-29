package com.wcj.chat.protocol.Packet;

import com.wcj.chat.protocol.Packet.serializer.Serializer;
import com.wcj.chat.enums.SerializerAlgorithm;
import com.wcj.chat.protocol.Packet.command.Command;
import io.netty.buffer.ByteBuf;

public class PacketCodec {


    public static final PacketCodec INSTANCE = new PacketCodec();





    public static void encode(ByteBuf byteBuf, Packet packet) {
        // 1. 序列化 java 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        // 2. 实际编码过程
        byteBuf.writeInt(Packet.MAGIC_NUMBER);
        byteBuf.writeByte(Packet.version);
        byteBuf.writeByte(packet.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand().getId());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }


    public static Packet decode(ByteBuf byteBuf) {
        // 跳过 magic number
        byteBuf.skipBytes(4);

        // 跳过版本号
        byteBuf.skipBytes(1);

        // 序列化算法
        byte serializeAlgorithm = byteBuf.readByte();

        // 指令
        byte command = byteBuf.readByte();




        // 数据包长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];

        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = Command.getPacketClass(command);

        Serializer serializer = SerializerAlgorithm.getStaticSerializer(serializeAlgorithm);

        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }

        return null;
    }


}
