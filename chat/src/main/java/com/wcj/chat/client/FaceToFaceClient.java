package com.wcj.chat.client;

import com.wcj.chat.client.handler.CreateGroupResponseHandler;
import com.wcj.chat.client.handler.JoinGroupResponseHandler;
import com.wcj.chat.protocol.Packet.handler.PacketCodecHandler;
import com.wcj.chat.client.console.ConsoleManager;
import com.wcj.chat.client.handler.LoginResponseHandler;
import com.wcj.chat.client.handler.MessageResponseHandler;
import com.wcj.chat.utils.SessionUtils;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:20
 * @Version 1.0.0
 */
public class FaceToFaceClient {
    private int port;

    private String host;

    private static final int MAX_RETRY = 5;

    public FaceToFaceClient(int port,String host){
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception{
        Bootstrap client = new Bootstrap();

        NioEventLoopGroup worker = new NioEventLoopGroup();

        client.group(worker)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new PacketCodecHandler());

                        ch.pipeline().addLast(new LoginResponseHandler());

                        ch.pipeline().addLast(new MessageResponseHandler());

                        ch.pipeline().addLast(new CreateGroupResponseHandler());

                        ch.pipeline().addLast(new JoinGroupResponseHandler());

                    }
                });
        connect(client,host,port,MAX_RETRY);

    }

    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println(new Date() + ": 连接成功，启动控制台线程……");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            } else if (retry == 0) {
                System.err.println("重试次数已用完，放弃连接！");
            } else {
                // 第几次重连
                int order = (MAX_RETRY - retry) + 1;
                // 本次重连的间隔
                int delay = 1 << order;
                System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
                bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit
                        .SECONDS);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        ConsoleManager consoleManager = new ConsoleManager();

        new Thread(()->{
            while(!Thread.interrupted()) {
                if (SessionUtils.isLogin(channel)) {
                    consoleManager.exec(channel);
                } else {
                    System.out.println("请先登录");
                    consoleManager.exec("login", channel);
                }
            }
        }).start();
    }
}
