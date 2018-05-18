package com.esx.test;


import org.junit.Test;

import com.esx.dao.IUserdao;
import com.esx.dao.impl.NoImplUserDao;
import com.esx.dao.impl.UserDao;

public class TestProxy {
	/**
	 * 测试cglib代理
	 * @throws Exception
	 */
	@Test
	public void testCglibProxy() throws Exception {
		
		CglibProxy proxy = new CglibProxy();
//		有实现类的
		IUserdao userdao = (IUserdao) proxy.getCglibTargetProxyInstance(new UserDao());
		userdao.save();
		userdao.get();
//		无实现类的
		NoImplUserDao userdao1=(NoImplUserDao) proxy.getCglibTargetProxyInstance(new NoImplUserDao());
		userdao1.add();
	}
	/**
	 * 测试jdk动态代理
	 * @throws Exception
	 */
	@Test
	public void testDynamicProxy() throws Exception {
		IUserdao userdao = (IUserdao) new DynamicProxy().getDynamicProxyTargetInstance(new UserDao());
		userdao.save();
		userdao.get();
	}
}
