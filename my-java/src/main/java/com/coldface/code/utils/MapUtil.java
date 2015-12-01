package com.coldface.code.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * map转换工具类
 * @author coldface
 *
 */
public class MapUtil {
	
	   //将map中的value数组转换成对象
		public static Map<String,Object> toMap(Map<String,Object[]> maps){
			Map<String,Object> map=new HashMap<String,Object>();
			for (String key : maps.keySet()) {  
				Object[] values = maps.get(key);
	            for (int i = 0; i < values.length; i++) {  
	                Object value = values[i];  
	                map.put(key, value);
	                
	            }  
	        } 
			return map;
		}


}
