package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.core.ActionMap;
import com.demo.core.NettyController;
import com.demo.entity.User;
import com.demo.message.Message;
import com.demo.userService.IUserServise;

import io.netty.channel.ChannelHandlerContext;

@NettyController
public class UserController {
	@Autowired
	private IUserServise userServise;
	@ActionMap(key=1)
	public String login(ChannelHandlerContext ctx,Message message) {
		String user = this.userServise.getUser();
		System.out.println(String.format("传入的内容是%s", message.getData()));
		return user;
	}
	@ActionMap(key=2)
	public String testelse(ChannelHandlerContext ctx,Message message) {
		String user = this.userServise.getUser();
		List<User> users=userServise.findAll();
		System.out.println(users.toString());
		System.out.println(String.format("调用service层返回的数据是%s", message.getData()+user));
		return user;
	}
}
