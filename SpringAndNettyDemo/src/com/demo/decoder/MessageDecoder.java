package com.demo.decoder;

import java.util.List;

import com.demo.message.Header;
import com.demo.message.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;

public class MessageDecoder extends ByteToMessageDecoder{
	public static final int HEAD_LENGTH=45;
	public static final byte PACKAGE_TAG=0x01;
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
		buffer.markReaderIndex();
		if(buffer.readableBytes()<HEAD_LENGTH) {
			throw new CorruptedFrameException("包长度有问题");
		}
		byte tag=buffer.readByte();
		if(tag!=PACKAGE_TAG) {
			throw new CorruptedFrameException("包标志错误");
		}
		byte encode=buffer.readByte();
		byte encrypt=buffer.readByte();
		byte extend1=buffer.readByte();
		byte extend2=buffer.readByte();
		byte sessionByte[]=new byte[32];
		buffer.readBytes(sessionByte);
		String sessionid=new String(sessionByte, "UTF-8");
		
		byte[] length1=new byte[4];
		buffer.readBytes(length1);
		int length = Message.bytesToInt(length1, 0);
		byte[] cammand1=new byte[4];
		buffer.readBytes(cammand1);
		int cammand = Message.bytesToInt(cammand1, 0);
		Header header=new Header(tag, encode, encrypt, extend1, extend2, sessionid, length, cammand);
		byte[] data=new byte[length];
		buffer.readBytes(data);
		Message message = new Message(header, new String(data, "UTF-8"));	
		out.add(message);
	}
}
