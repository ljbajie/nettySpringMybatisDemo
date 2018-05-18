package com.esx.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @author 二师兄
 *
 */
public class CglibProxy implements MethodInterceptor {
	private Object target; 
	public Object getCglibTargetProxyInstance(Object target) {
		this.target=target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("method run before。。。。。");
		Object returnValue = proxy.invokeSuper(obj, args);
		System.out.println("method run after...........");
		return returnValue; 
	}	
}
