package com.xu.refactor.chapter6;

import java.util.Arrays;
import java.util.List;

/**
 * 替换算法-把某个算法替换成另一个更清晰的算法
 * @author 39767
 *
 */
public class SubstituteAlgorithm {

	public String foundPerson(String[] people){
		for(String p : people){
			if(p.equals("Don"))
				return "Don";
			if(p.equals("John"))
				return "John";
			if(p.equals("Kent"))
				return "Kent";
		}
		return "";
	}
	
	public String foundPerson_R(String[] people){
		List<String> candidates = Arrays.asList(new String[]{"Don", "John", "Kent"});
		for(String p : people){
			if(candidates.contains(p))
				return p;
		}
		return "";
	}
}
