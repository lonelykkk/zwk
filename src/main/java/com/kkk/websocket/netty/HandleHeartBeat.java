package com.kkk.websocket.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;

/**
 ClassName: HandleHeartBeat
 Description:
 @Author Keanu
 @Create 2024/5/26 22:40
 */
@Slf4j
public class HandleHeartBeat extends ChannelDuplexHandler {

    /**
     * 如果客户端处于 读取空闲 状态（即未接收到数据），则记录日志并关闭连接。
     * 如果客户端处于 写空闲 状态（即未发送数据），则向客户端发送心跳消息保持连接。
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            if (e.state() == IdleState.READER_IDLE) {
                Channel channel = ctx.channel();
                Attribute<String> attribute = channel.attr(AttributeKey.valueOf(channel.id().toString()));
                String userId = attribute.get();
                log.info("用户{}心跳超时", userId);
                ctx.close();
            } else if (e.state() == IdleState.READER_IDLE) {
                ctx.writeAndFlush("heart");
            }
        }
    }
}
