package com.wcj.chat.utils;


import com.wcj.chat.entity.Group;
import com.wcj.chat.entity.User;
import com.wcj.chat.enums.AttributeKeyEnums;
import io.netty.channel.Channel;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 15:21
 * @Version 1.0.0
 */
public class SessionUtils {
    public static final ConcurrentHashMap<User,Channel> sessionMap = new ConcurrentHashMap<>(32);

    private static final ConcurrentHashMap<String, Group> GroupMap= new ConcurrentHashMap<>(32);

    public static final void setGroup(Group group){
        GroupMap.put(group.getName(), group);
    }
    public static Map<String,Group> getGroupMap(){
        return GroupMap;
    }

    public static void bindSesion(User user, Channel channel){
            if(sessionMap.containsKey(user)){
                System.out.println(user.getUsername()+"--用户已登录 ");
            }else{
                sessionMap.put(user,channel);

            }
            channel.attr(AttributeKeyEnums.SESSION).set(user);


    }
    public static boolean isLogin(Channel channel){

        return getSession(channel)!=null;
    }
    public static void logout(Channel channel){
        if(isLogin(channel)){
            User user = channel.attr(AttributeKeyEnums.SESSION).get();
            sessionMap.remove(user);

            channel.attr(AttributeKeyEnums.SESSION).set(null);
            System.out.println(user.toString()+"---->登出");
        }
    }
    public static Channel getChannel(String username){
        for(Map.Entry<User,Channel> entry : sessionMap.entrySet()){
            User user = entry.getKey();
            Channel channel  = entry.getValue();
            if(user.getUsername().equals(username)){
                return  channel;
            }
        }
        return null;
    }

    public static User getSession(Channel channel){
        return channel.attr(AttributeKeyEnums.SESSION).get();
    }

    public static String printList(Set<String> channelList){
        StringBuilder str = new StringBuilder("群内成员有:[");
        for(String user: channelList){
            str.append(user+" ");
        }
        str.append("]");
        return str.toString();
    }
}
