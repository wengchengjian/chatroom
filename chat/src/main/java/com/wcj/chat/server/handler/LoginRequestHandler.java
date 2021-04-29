package com.wcj.chat.server.handler;

import com.wcj.chat.entity.User;
import com.wcj.chat.protocol.Packet.request.LoginRequestPacket;
import com.wcj.chat.protocol.Packet.response.LoginResponsePacket;
import com.wcj.chat.enums.ResponseStatus;
import com.wcj.chat.utils.SessionUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 14:30
 * @Version 1.0.0
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    public static final ChannelHandler INSTANCE = new LoginRequestHandler();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }




    public boolean valid(User user){
        return true;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg) throws Exception {
        LoginRequestPacket user_Login = msg;

        User user = user_Login.getUser();

        LoginResponsePacket responsePacket=new LoginResponsePacket();
        if(valid(user)){
            responsePacket.setResponseStatus(ResponseStatus.SUCCESS);
            responsePacket.setUser(user);
            SessionUtils.bindSesion(user,ctx.channel());
            System.out.println("[" + user.getUsername() + "]登录成功");
        }else{
            responsePacket.setResponseStatus(ResponseStatus.FAILED);
        }
        ctx.channel().writeAndFlush(responsePacket);
    }
}
