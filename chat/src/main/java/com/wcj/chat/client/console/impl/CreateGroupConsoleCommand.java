package com.wcj.chat.client.console.impl;

import com.wcj.chat.entity.Group;
import com.wcj.chat.protocol.Packet.request.CreateGroupRequestPacket;
import com.wcj.chat.client.console.ConsoleCommand;
import com.wcj.chat.enums.AttributeKeyEnums;
import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 10:37
 * @Version 1.0.0
 */
public class CreateGroupConsoleCommand implements ConsoleCommand {
    public static final CreateGroupConsoleCommand CREATE_CONSOLE_COMMAND = new CreateGroupConsoleCommand();

    @Override
    public void exec(Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();
        Scanner in = new Scanner(System.in);
        System.out.print("请输入群聊名称: ");
        String groupName = in.nextLine();

        List<String> users = new ArrayList<>();

        users.add(channel.attr(AttributeKeyEnums.SESSION).get().getUsername());

        System.out.println("请输入需要邀请的用户id:");
        while(!in.nextLine().equals("finished")){
            String username = in.nextLine();
            users.add(username);
        }
        Group group = new Group();

        group.setName(groupName);
        group.setUsers(users);

        createGroupRequestPacket.setGroup(group);
        channel.writeAndFlush(createGroupRequestPacket);
    }
}
