package com.wcj.chat.enums;

import com.wcj.chat.client.console.ConsoleCommand;
import com.wcj.chat.client.console.impl.*;


/**
 * @Author 翁丞健
 * @Date:2021/4/28 16:04
 * @Version 1.0.0
 */
public enum ConsoleCommandEnums {
    /**
     * 登录
     */
    HELP("help", HelpConSoleCommand.HELP_CONSOLE_COMMAND),
    LOGIN("login", LoginConsoleCommand.LOGIN_CONSOLE_COMMAND),
    SEND("sendMessage", MessageConsoleCommand.MESSAGE_CONSOLE_COMMAND),
    JOIN_GROUP("join", JoinGroupConsoleCommand.JOIN_CONSOLE_COMMAND),
    CREATE_GROUP("create", CreateGroupConsoleCommand.CREATE_CONSOLE_COMMAND),
    LIST_GROUP("list",ListGroupMemberConsoleCommand.LIST_GROUP_COMMAND),
    SEND_GROUP("send_group",SendGroupConsoleCommand.SEND_GROUP_COMMAND);


    String desc;
    ConsoleCommand consoleCommand;

    ConsoleCommandEnums(String desc,ConsoleCommand consoleCommand){
        this.consoleCommand = consoleCommand;
        this.desc = desc;
    }

    public String getDesc(){
        return this.desc;
    }

    public ConsoleCommand getConsoleCommand(){
        return this.consoleCommand;
    }

    public static ConsoleCommand getConsoleCommand(String desc){
        ConsoleCommandEnums[] consoleCommandEnumses = values();
        for(ConsoleCommandEnums consoleCommandEnums : consoleCommandEnumses){
            if(consoleCommandEnums.getDesc().equals(desc)){
                return consoleCommandEnums.getConsoleCommand();
            }
        }
        return null;
    }
}
