package com.demo.userService.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.entity.User;
import com.demo.mapper.IUserDao;
import com.demo.userService.IUserServise;

@Component
public class UserServiseImpl implements IUserServise {

	@Autowired
	IUserDao usermapper;
	@Override
	public String getUser() {
		return "22222";
	}
	@Override
	public List<User> findAll() {
		return usermapper.finduser();
	}
}
