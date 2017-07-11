package com.xu.base;

import java.util.HashMap;
import java.util.Map;

public class XuMap {
	
	public static void main(String[] arg){
		
		Map<String, Integer> map = new HashMap<>();
		String z = new String("1");
		map.put(z, 1);
		
		System.out.println(map.get("1"));
		String a = "1";
		System.out.println(a.equals(z));
		System.out.println(map.get(a));
		String b = new String("1");
		System.out.println(map.get(b));
		String c = new String("1");
		System.out.println(map.get(c));
	}

}
