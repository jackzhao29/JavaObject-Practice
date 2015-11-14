package com.coldface.code.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String,String> map=addMaps();
		String key,value;
		//第一种keySet遍历key+value
		Iterator<String> it=map.keySet().iterator();
		while(it.hasNext()){
			key = it.next();
			value = map.get(key);
			System.out.println("{"+key+":"+value+"}");
		}
		//第二种keySet遍历key+value
		for(String keys:map.keySet()){
			value = map.get(keys);
		}
		
		//第一种entrySet遍历key+value
		Iterator<Entry<String,String>> iter=map.entrySet().iterator();
		Entry<String,String> entry;
		while(iter.hasNext()){
			entry=iter.next();
			key=entry.getKey();
			value=entry.getValue();
		}
		
		//第二种entrySet遍历key+value
		for(Entry<String,String> entrys:map.entrySet()){
			key = entrys.getKey();
			value=entrys.getValue();
			System.out.println("===={"+key+":"+value+"}");
		}
	}
	
	private static Map<String,String> addMaps(){
		Map<String, String> map = new HashMap<String, String>();  
		String key, value;  
		for (int i = 1; i <= 100; i++) {  
		    key = "" + i;  
		    value = "value";  
		    map.put(key, value);  
		}
		return map;
	}
	

}
