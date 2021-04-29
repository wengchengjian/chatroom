package com.wcj.chat.client.console.impl;

import com.wcj.chat.client.console.ConsoleCommand;
import com.wcj.chat.protocol.Packet.request.ListGroupMemberRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 15:19
 * @Version 1.0.0
 */
public class ListGroupMemberConsoleCommand implements ConsoleCommand {
    public static final ListGroupMemberConsoleCommand LIST_GROUP_COMMAND = new ListGroupMemberConsoleCommand();

    @Override
    public void exec(Channel channel) {
        System.out.print("请输入群聊名称:");

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        ListGroupMemberRequestPacket listGroupMemberRequestPacket  = new ListGroupMemberRequestPacket();
        listGroupMemberRequestPacket.setGroupName(str);
        channel.writeAndFlush(listGroupMemberRequestPacket);
    }
}
