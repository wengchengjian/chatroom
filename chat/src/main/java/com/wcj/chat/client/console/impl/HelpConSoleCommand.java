package com.wcj.chat.client.console.impl;

import com.wcj.chat.client.console.ConsoleCommand;
import com.wcj.chat.enums.ConsoleCommandEnums;
import io.netty.channel.Channel;

/**
 * @Author 翁丞健
 * @Date:2021/4/29 10:43
 * @Version 1.0.0
 */
public class HelpConSoleCommand implements ConsoleCommand {
    public static final ConsoleCommand HELP_CONSOLE_COMMAND =  new HelpConSoleCommand();

    @Override
    public void exec(Channel channel) {
        ConsoleCommandEnums[] values = ConsoleCommandEnums.values();
        System.out.println("目前有"+values.length+"种命令 请选择以下一种: ");
        for(ConsoleCommandEnums consoleCommandEnums : values){
            System.out.print(consoleCommandEnums.getDesc()+" ");
        }
    }
}
