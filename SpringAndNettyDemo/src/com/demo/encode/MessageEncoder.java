package com.demo.encode;

import com.demo.decoder.MessageDecoder;
import com.demo.message.Header;
import com.demo.message.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MessageEncoder extends MessageToByteEncoder<Message>{

	@Override
	protected void encode(ChannelHandlerContext arg0, Message msg, ByteBuf out) throws Exception {
		Header header = msg.getHeader();
		out.writeByte(MessageDecoder.PACKAGE_TAG);
		out.writeByte(header.getEncode());
		out.writeByte(header.getEncrypt());
		out.writeByte(header.getExtend1());
		out.writeByte(header.getExtend2());
		out.writeBytes(header.getSessionid().getBytes());
		out.writeInt(header.getLength());
		out.writeInt(header.getCammand());
		out.writeBytes(msg.getData().getBytes("UTF-8"));
	}

}
