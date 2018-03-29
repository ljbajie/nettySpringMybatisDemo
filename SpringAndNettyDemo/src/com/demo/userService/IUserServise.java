package com.demo.userService;

import java.util.List;

import com.demo.entity.User;

public interface IUserServise {
	
	public String getUser();
	
	public List<User> findAll();

}
