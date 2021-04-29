package com.wcj.chat.client.console.impl;

import com.wcj.chat.protocol.Packet.request.LogoutRequestPacket;
import com.wcj.chat.client.console.ConsoleCommand;
import io.netty.channel.Channel;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 12:44
 * @Version 1.0.0
 */
public class LogoutConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();

    }
}
