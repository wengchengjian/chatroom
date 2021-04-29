package com.wcj.chat.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 15:59
 * @Version 1.0.0
 */
public interface ConsoleCommand {

    void exec(Channel channel);
}
