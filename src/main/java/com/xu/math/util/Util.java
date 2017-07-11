package com.xu.math.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
	public static int ZERO = 0;
	public static int ONE = 1;
	public static int THREE = 3;
	public static int SIX = 6;
	
	public static void main(String[] args){
		arr2String();
	}
	
	public static void getHtml(){
		String url = "aaaa<a herf = \"11\">asdasd</a>aaaa<a herf = \"11\">asdasd</a>";
		String[] html = url.split("\\<a|\\/a>");
		
		for(int i = 0; i < html.length; i++){
			if(html[i].contains(">") || html[i].contains("<")){
				System.out.println("<a" + html[i] + "/a>");
			}
		}
		
	}
	
	public static void arr2String() {
		String[] arr = new String[]{"1", "2", "3", "4"};
		List<String> list = new ArrayList<>();
		list.add("7");
		list.add("8");
		list.add("9");
		
		System.out.println(Arrays.asList(arr));
	}
}
