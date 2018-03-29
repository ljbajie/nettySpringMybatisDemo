package com.demo.handler;

import com.demo.message.Header;
import com.demo.message.Message;
import com.demo.util.ActionMapUtil;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter{
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String content="收到连接";
		System.out.println("连接上了........");
		Header header=new Header((byte)1, (byte)1, (byte)1, (byte)1, (byte)0, "713f17ca614361fb257dc6741332caf2", content.getBytes("UTF-8").length, 1);
		Message message=new Message(header, content);
		ctx.writeAndFlush(message);
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		//ctx.close();
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		   Message message=(Message) msg;
		   /**
		    * 请求分发
		    */
		   ActionMapUtil.invoke(message.getHeader().getCammand(),ctx,message);
	}
}
