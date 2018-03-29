package com.demo.mapper;


import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.entity.User;

@Component
public interface IUserDao {
	
	public List<User> finduser();

}
