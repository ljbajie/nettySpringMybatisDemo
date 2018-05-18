package com.esx.dao.impl;

import com.esx.bean.Agen;
import com.esx.bean.User;
import com.esx.dao.IUserdao;

public class UserDao implements IUserdao{
	User user=new User("张三", "123456", Agen.MAN);
	@Override
	public void save() {
		System.out.println(user.toString());
	}
	@Override
	public void get() {
		System.out.println(user.getUsername());
	}
}
