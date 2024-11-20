package com.kkk.websocket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.concurrent.TimeUnit;

/**
 * @author lonelykkk
 * @email 2765314967@qq.com
 * @date 23/7/2024 下午 5:53
 * @Version V1.0
 */
public class NettyWebSocketStarter {

    private static final Logger logger = LoggerFactory.getLogger(HandlerWebSocket.class);
    /**
     在 Netty 中，EventLoopGroup 是处理所有网络 I/O 操作的核心组件，负责分配和管理线程，
     以执行网络事件（如连接、读写等）的处理。NioEventLoopGroup 是一种基于 NIO（Non-blocking I/O）模型的事件循环组，
     通常用于处理高并发的网络通信任务。
     */
    private static EventLoopGroup bossGroup = new NioEventLoopGroup(1); // 用 1 个线程来监听客户端连接
    private static EventLoopGroup workGroup = new NioEventLoopGroup(); // 默认使用 CPU 核心数 * 2 个线程，


    public static void main(String[] args) {
        try {
            /**
             * ServerBootstrap 是 Netty 提供的一个重要类，用于构建和启动一个服务器应用程序。
             * 它负责配置和启动服务器的相关组件（如 I/O 线程、通道、管道处理器等），并启动服务器的监听和连接处理。
             * ServerBootstrap 提供了一个简单的 API 来设置服务器所需的各个参数，使得服务器的启动过程变得简洁而灵活。
             */
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup); //bossGroup 负责接收客户端连接，workGroup 负责处理已连接客户端的 I/O 操作（如读写数据）
            serverBootstrap.channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel channel) throws Exception {
                    ChannelPipeline pipeline = channel.pipeline();
                    // 对http协议的支持
                    pipeline.addLast(new HttpServerCodec());
                    //聚合解码 httpRequest/htppContent/lastHttpContent到fullHttpRequest
                    //保证接收的http请求的完整性
                    pipeline.addLast(new HttpObjectAggregator(64 * 1024));
                    //心跳 long readerIdleTime, long writerIdleTime, long allIdleTime, TimeUnit unit
                    // readerIdleTime  读超时事件 即测试段一定事件内未接收到被测试段消息
                    // writerIdleTime  为写超时时间 即测试端一定时间内向被测试端发送消息
                    //allIdleTime  所有类型的超时时间
                    pipeline.addLast(new IdleStateHandler(6, 0, 0, TimeUnit.SECONDS));
                    //自定义处理 心跳检测 和 超时连接关闭 的逻辑，此类继承ChannelDuplexHandler
                    pipeline.addLast(new HandleHeartBeat());
                    //将http协议升级为ws协议，对websocket支持-协议处理器
                    pipeline.addLast(new WebSocketServerProtocolHandler("/ws", null, true, 60 * 1024, true, true, 10000L));
                    //自定义处理
                    pipeline.addLast(new HandlerWebSocket());
                }
            });

            ChannelFuture channelFuture = serverBootstrap.bind(5051).sync(); //服务端口
            logger.info("netty服务启动成功");
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("启动netty失败",e);
        }finally {
            //关闭通道
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
