package com.wcj.chat.client.console.impl;

import com.wcj.chat.entity.User;
import com.wcj.chat.protocol.Packet.request.LoginRequestPacket;
import com.wcj.chat.client.console.ConsoleCommand;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 16:06
 * @Version 1.0.0
 */
public class LoginConsoleCommand implements ConsoleCommand {
    public static final LoginConsoleCommand LOGIN_CONSOLE_COMMAND = new LoginConsoleCommand();

    @Override
    public void exec(Channel channel) {
        User user = new User();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String username  = in.nextLine();
        System.out.println("请输入密码");
        String password  = in.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        LoginRequestPacket requestPacket = new LoginRequestPacket(user);

        channel.writeAndFlush(requestPacket);
        waitForLoginResponse();
    }
    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
