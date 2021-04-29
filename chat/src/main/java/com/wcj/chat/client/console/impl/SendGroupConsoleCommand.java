package com.wcj.chat.client.console.impl;

import com.wcj.chat.client.console.ConsoleCommand;
import com.wcj.chat.protocol.Packet.request.SendGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 18:19
 * @Version 1.0.0
 */
public class SendGroupConsoleCommand  implements ConsoleCommand {
    public static final SendGroupConsoleCommand SEND_GROUP_COMMAND = new SendGroupConsoleCommand() ;

    @Override
    public void exec(Channel channel) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入群聊名称: ");
        String groupName = in.nextLine();
        System.out.print("请输入要发送的消息:");
        String message = in.nextLine();

        SendGroupRequestPacket sendGroupRequestPacket = new SendGroupRequestPacket();
        sendGroupRequestPacket.setGroupName(groupName);
        sendGroupRequestPacket.setMessgae(message);

        channel.writeAndFlush(sendGroupRequestPacket);
    }
}
