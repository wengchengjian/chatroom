package com.wcj.chat.client.console.impl;

import com.wcj.chat.entity.Message;
import com.wcj.chat.protocol.Packet.request.MessageRequestPacket;
import com.wcj.chat.client.console.ConsoleCommand;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 9:31
 * @Version 1.0.0
 */
public class MessageConsoleCommand implements ConsoleCommand {
    public static final MessageConsoleCommand MESSAGE_CONSOLE_COMMAND = new MessageConsoleCommand();

    @Override
    public void exec(Channel channel) {
        System.out.println("请输入好友id: ");
        Scanner in = new Scanner(System.in);
        String username = in.nextLine();
        System.out.println("请输入发送消息: ");
        String msg = in.nextLine();
//        设置发送消息包
        MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
//        设置发送消息
        Message message = new Message();
        message.setMsg(msg);
        message.setTargetUsername(username);
        message.setSourceUsername(SessionUtils.getSession(channel).getUsername());

        messageRequestPacket.setMessage(message);

        channel.writeAndFlush(messageRequestPacket);
    }
}
