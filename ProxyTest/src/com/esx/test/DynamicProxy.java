package com.esx.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author 动态代理
 *
 */

public class DynamicProxy implements InvocationHandler {
    private Object target;
    /*public DynamicProxy(Object target) {
    	this.target=target;
	}*/
    public Object getDynamicProxyTargetInstance(Object target) {
    	this.target=target;
    	return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
    			target.getClass().getInterfaces(), this);
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	    Object returnValue=null;
		System.out.println("before calling :"+method);
	    if("save".equals(method.getName())) {
	    	  method.invoke(target, args);
	    }
	    System.out.println("after calling :"+method);
		return returnValue;
	}
}
