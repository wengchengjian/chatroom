package com.wcj.chat.client.console;

import com.wcj.chat.enums.ConsoleCommandEnums;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 15:56
 * @Version 1.0.0
 */
public class ConsoleManager implements ConsoleCommand{


    @Override
    public void exec(Channel channel) {
        System.out.println("请输入指令: " );
        Scanner in  = new Scanner(System.in);
        String str = in.nextLine();
        exec(str,channel);
    }

    public void exec(String command,Channel channel){
        ConsoleCommand consoleCommand= ConsoleCommandEnums.getConsoleCommand(command);
        if(consoleCommand!=null){
            consoleCommand.exec(channel);
        }
    }
}
