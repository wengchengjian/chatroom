package com.wcj.chat.client.console.impl;

import com.wcj.chat.protocol.Packet.request.JoinGroupRequestpacket;
import com.wcj.chat.client.console.ConsoleCommand;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 10:39
 * @Version 1.0.0
 */
public class JoinGroupConsoleCommand implements ConsoleCommand {
    public static final JoinGroupConsoleCommand JOIN_CONSOLE_COMMAND = new JoinGroupConsoleCommand();

    @Override
    public void exec(Channel channel) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入群聊名称: ");
        String groupName;

        groupName = in.nextLine();




        JoinGroupRequestpacket joinGroupRequestpacket = new JoinGroupRequestpacket();

        joinGroupRequestpacket.setGroupName(groupName);

        channel.writeAndFlush(joinGroupRequestpacket);
    }
}
