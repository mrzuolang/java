package org.job.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {
	public static Map<String,Object> objectToMap(Object obj,Class<?> classs){
		Field[] fields = classs.getDeclaredFields();
		Map<String,Object>res = new HashMap<String, Object>();
		for (Field field : fields) {
			try {
				field.setAccessible(true); //设置些属性是可以访问的
				Object value = field.get(obj);
				res.put(field.getName(), value);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return res;
	}
}
