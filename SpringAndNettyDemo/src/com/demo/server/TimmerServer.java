package com.demo.server;



import org.springframework.stereotype.Component;

import com.demo.decoder.MessageDecoder;
import com.demo.encode.MessageEncoder;
import com.demo.handler.ServerHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

@Component
public class TimmerServer {
	private int port=8888;
	public void run() throws InterruptedException {
		EventLoopGroup bossGroup=new NioEventLoopGroup();
		EventLoopGroup workerGroup=new NioEventLoopGroup();
		ByteBuf heapBuffer=Unpooled.buffer(8);
		heapBuffer.writeBytes("\r".getBytes());
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							System.out.println("------------------------执行");
							 /*ch.pipeline().addLast(new LineBasedFrameDecoder(65535));
							 ch.pipeline().addLast("encoder", new MessageEncoder())
									.addLast("decoder", new MessageDecoder())
									.addLast(new ServerHandler());*/
							ch.pipeline().addLast("encoder",new MessageEncoder())
							.addLast("decoder",new MessageDecoder())
							.addFirst(new LineBasedFrameDecoder(65535))
							.addLast(new ServerHandler());
						}
						
					}).option(ChannelOption.SO_BACKLOG,1024).childOption(ChannelOption.SO_KEEPALIVE, true);
			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
	public void start(int port) throws InterruptedException {
		this.port=port;
		this.run();
	}

} 
