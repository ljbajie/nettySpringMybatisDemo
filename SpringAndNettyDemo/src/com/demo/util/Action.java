package com.demo.util;

import java.lang.reflect.Method;

public class Action {
	private Method method;
	private Object object;
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
}
