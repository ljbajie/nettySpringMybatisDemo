package com.demo.util;
/**
 * 分发请求的帮助类
 * @author Administrator
 *
 */

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ActionMapUtil {
	private static Map<Integer, Action> map=new HashMap<>();
	public static Object invoke(Integer key,Object...parms) throws Exception {
		Action action = map.get(key);
		if(action!=null) {
			Method method = action.getMethod();
			try {
				return method.invoke(action.getObject(), parms);
			} catch (Exception e) {
				throw e;
			}
		}
		return null;
	}
	public static void put(Integer key,Action action) {
		map.put(key, action);
	}
}
