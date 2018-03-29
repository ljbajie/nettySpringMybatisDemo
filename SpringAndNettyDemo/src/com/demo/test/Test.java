package com.demo.test;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.server.TimmerServer;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TimmerServer server = ac.getBean(TimmerServer.class);
		try {
			System.out.println("启动服务器....");
			server.start(8888);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
