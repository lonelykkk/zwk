package com.kkk.websocket.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@ChannelHandler.Sharable
public class HandlerWebSocket extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    /**
     * 用于处理每个传入的消息。传入的消息是 TextWebSocketFrame 类型的对象，它代表一个 WebSocket文本帧。
     *
     * @param channelHandlerContext
     * @param textWebSocketFrame
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        Channel channel = channelHandlerContext.channel();
        Attribute<String> attribute = channel.attr(AttributeKey.valueOf(channel.id().toString()));
        String userId = attribute.get();
        log.info("收到消息的消息:{}", textWebSocketFrame.text());
    }

    /**
     * 通道就绪后 调用，一般用来做初始化
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("有新的连接加入...");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("有连接断开...");
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            WebSocketServerProtocolHandler.HandshakeComplete complete = (WebSocketServerProtocolHandler.HandshakeComplete) evt;
            String url = complete.requestUri();
            log.info("url:{}", url);
        }
    }

}
