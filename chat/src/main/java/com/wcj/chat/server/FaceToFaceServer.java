package com.wcj.chat.server;

import com.wcj.chat.protocol.Packet.handler.PacketCodecHandler;
import com.wcj.chat.server.handler.LoginRequestHandler;
import com.wcj.chat.server.handler.MessageRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.Date;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:20
 * @Version 1.0.0
 */
public class FaceToFaceServer {
    private final int port;

    public FaceToFaceServer(int port){
        this.port = port;
    }

    public void run() throws Exception{
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(boosGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {

                        ch.pipeline().addLast(new PacketCodecHandler());
                        ch.pipeline().addLast(new LoginRequestHandler());
                        ch.pipeline().addLast(new MessageRequestHandler());

                    }
                });


        bind(serverBootstrap, port);

    }
    public void bind(final ServerBootstrap server,int port) throws InterruptedException {
        server.bind(new InetSocketAddress(port)).addListener((future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
            }
        }));
    }
}
