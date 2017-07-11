package com.xu.base.copy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseController {

	//数字校验
    public boolean isNumber(String str) {
    	Pattern pattern = Pattern.compile("[0-9]+");
    	Matcher isNum = pattern.matcher(str);
    	if (!isNum.matches()) {
    		return false;
    	}
    	return true;
    }
    
    
}
