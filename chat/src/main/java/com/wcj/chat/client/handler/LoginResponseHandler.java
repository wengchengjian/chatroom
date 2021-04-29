package com.wcj.chat.client.handler;

import com.wcj.chat.entity.User;
import com.wcj.chat.protocol.Packet.response.LoginResponsePacket;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 15:50
 * @Version 1.0.0
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    public static final LoginResponseHandler INSTANCE = new LoginResponseHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) throws Exception {
        LoginResponsePacket resposne  = msg;


        if(resposne.getResponseStatus()== ResponseStatus.SUCCESS){
            User user = resposne.getUser();
            SessionUtils.bindSesion(user, ctx.channel());

        }else if(resposne.getResponseStatus()==ResponseStatus.FAILED){
            System.out.println(ResponseStatus.FAILED.getMsg());
        }
    }
}
