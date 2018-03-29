package com.demo.core;

import java.lang.reflect.Method;

import org.springframework.beans.factory.config.BeanPostProcessor;

import com.demo.util.Action;
import com.demo.util.ActionMapUtil;

public class ActionBeanPostProcessor implements BeanPostProcessor{
	public Object postProcessBeforeInitialization(Object bean,String beanName) {
		return bean;
	}
	public Object postProcessAfterInitialization(Object bean,String beanName) {
		Method[] methods = bean.getClass().getMethods();
		for (Method method : methods) {
			ActionMap 	actionMap=method.getAnnotation(ActionMap.class);
			if (actionMap!=null) {
				Action action=new Action();
				action.setMethod(method);
				action.setObject(bean);
				ActionMapUtil.put(actionMap.key(), action);
			}
		}
		return bean;
	}
}
