package com.xu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xu.base.BaseController;
import com.xu.util.QrCodeUtil;

@Controller
@RequestMapping("/")
public class UserController extends BaseController{
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(){
        return "index"; 
	}
	
    @RequestMapping(value = "/triangle", method = RequestMethod.GET)  
    public String getTriangle() {
        return "triangle";  
    }
    
	
    @RequestMapping(value = "/verge", method = RequestMethod.GET)  
    public String getVerge() {
        return "verge";
    }
	
	@ResponseBody
	@RequestMapping(value="/getTriangle")
	public Map<String, String> getTriangle(@RequestParam String a, @RequestParam String b, @RequestParam String c) {
		Map<String, String> map = new HashMap<>();

		// 非空校验
		if (a == null || "".equals(a) || b == null || "".equals(b) || c == null || "".equals(c)) {
			map.put("msg", "边长不能为空");
			return map;
		}
		// 数字校验
		if(!isNumber(a) || !isNumber(b) || !isNumber(c)){
			map.put("msg", "边长必须为正整数，不能包含英文、符号或小数点");
			return map;			
		}
		
		//类型转换
		Integer A = Integer.valueOf(a);
		Integer B = Integer.valueOf(b);
		Integer C = Integer.valueOf(c);
		
		// 数值上限200校验
		if(A > 200 || B >200 || C > 200){
			map.put("msg", "边长最大不超过200");
			return map;
		}
		
		//将a,b,c从小到大排序
		Integer temp = null;
		if(A > B){
			temp = A;
			A = B;
			B = temp;
		}
		if(A > C){
			temp = A;
			A = C;
			C = temp;
		}
		if(B > C){
			temp = B;
			B = C;
			C = temp;
		}
		
		//判断三角形
		if(A + B <= C ){
			map.put("msg", "三边不构成三角形");
			return map;
		}
		else if(A == C){
			map.put("msg", "三边构成等边三角形");
			return map;
		}else if (A == B || B == C) {
			map.put("msg", "三边构成等腰三角形");
			return map;
		}else if(A*A + B*B == C*C){
			map.put("msg", "三边构成直角三角形");
			return map;
		}else {
			map.put("msg", "三边构成普通三角形");
			return map;
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/getNextDate", method = RequestMethod.POST)
	public Map<String, String> getNextDate(@RequestParam String year, @RequestParam String month,
			@RequestParam String day) {
		Map<String, String> map = new HashMap<>();

		//非空校验
		if("".equals(year) || "".equals(month) || "".equals(day)){
			map.put("msg", "日期不能为空");
			return map;
		}
		
		// 数字校验
		if(!isNumber(year) || !isNumber(month) || !isNumber(day)){
			map.put("msg", "日期必须为数字，不能包含符号或英文");
			return map;			
		}
		
		//类型转换
		Integer yyyy = Integer.valueOf(year);
		Integer mm = Integer.valueOf(month);
		Integer dd = Integer.valueOf(day);
		
		//年份大小校验
		if(yyyy > 9999 || yyyy < 1900){
			map.put("msg", "年份只能在[1900, 9999]内");
			return map;	
		}
		
		//月份大小校验
		if(mm > 12 || mm < 1){
			map.put("msg", "月份只能在[1, 12]内");
			return map;	
		}
		
		//日期大小校验
		if(dd > 31 || dd < 1){
			map.put("msg", "日期只能在[1, 31]内");
			return map;	
		}
		
		//特定日期校验
    	if(mm == 4 || mm == 6 || mm == 9 || mm == 11 && dd > 30){
    		map.put("msg", mm + "月份只有30天");
			return map;
    	}
    	else if(isLeapYear(yyyy) && mm == 2 && dd > 29){
    		map.put("msg", mm + "月份只有29天");
			return map;
    	}
    	else if(!isLeapYear(yyyy) && mm == 2 && dd > 28){
    		map.put("msg", mm + "月份只有28天");
			return map;
    	}
		
    	//下一日处理
		if(isEndYear(mm,dd)){
			map.put("msg", "下一日是" + (yyyy + 1) + " - " + "1" + " - " + "1");
			return map;	
		}
		else if(isEndMonth(yyyy, mm, dd)){
			map.put("msg", "下一日是" + yyyy + " - " + (mm + 1) + " - " + "1");
			return map;	
		}
		else{
			map.put("msg", "下一日是" + yyyy + " - " + mm + " - " + (dd + 1));
			return map;	
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value="/getFibonacci", method = RequestMethod.POST)
	public Map<Object, Object> getFibonacci(@RequestParam(value="fiboMax") String max){
		long start = System.currentTimeMillis();
		long end;
		Map<Object, Object> map = new HashMap<>();
		
		//非空校验
		if("".equals(max)){
			map.put("msg", "输入值不能为空");
			end = System.currentTimeMillis();
			map.put("time", end - start + "ms");
			return map;
		}
		
		//数字校验
		if(!isNumber(max)){
			map.put("msg", "输入值必须为数字，不能包含符号或英文");
			end = System.currentTimeMillis();
			map.put("time", end - start + "ms");
			return map;	
		}
			
		//String转int
		int Max = Integer.valueOf(max).intValue();
		ArrayList<Long> list = new ArrayList<>();		
		Long first = 1L;
		Long second = 1L;
		
		list.add(first);
		list.add(second);
		for(int i = 2; i < Max; i++){
			list.add(list.get(i - 2) + list.get(i - 1));
		}
		
		map.put("msg", list.toString());
		end = System.currentTimeMillis();
		map.put("time", end - start + "ms");
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/getErastothenes", method = RequestMethod.POST)
	public Map<Object, Object> getErastothenes(@RequestParam(value="erasMax") String max){
		long start = System.currentTimeMillis();
		long end;
		Map<Object, Object> map = new HashMap<>();
		
		//非空校验
		if("".equals(max)){
			map.put("msg", "输入值不能为空");
			end = System.currentTimeMillis();
			map.put("time", end - start + "ms");
			return map;
		}
		
		//数字校验
		if(!isNumber(max)){
			map.put("msg", "输入值必须为数字，不能包含符号或英文");
			end = System.currentTimeMillis();
			map.put("time", end - start + "ms");
			return map;	
		}
			
		//String转int
		int Max = Integer.valueOf(max).intValue();
		ArrayList<Integer> list = new ArrayList<>();
		
		for(Integer i = 2; i <= Max; i++){
			list.add(i);
		}
		
		Integer temp = 2;
		while(temp * temp <= Max){
			Integer j = 2;
			while (temp * j <= Max) {
				list.set(temp * j - 2, 0);
				j++;
			}
			temp++;
		}
		
		ArrayList<Integer> resultList = new ArrayList<>();
		for(Integer i : list){
			if(i != 0){
				resultList.add(i);
			}
		}
		
		map.put("msg", resultList.toString());
		end = System.currentTimeMillis();
		map.put("time", end - start + "ms");
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/getTwo", method = RequestMethod.POST)
	public Map<Object, Object> getTwo(){
		Map<Object, Object> map = new HashMap<>();
		QrCodeUtil code = new QrCodeUtil();
		map.put("image", code.encoderQRCode());
		return map;
	}
	
    //闰年校验
    private boolean isLeapYear(Integer year) {
    	if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
    		return true;
    	else
    		return false;
    }
    
    //年末校验
    private boolean isEndYear(Integer month, Integer day) {
    	if(month == 12 && day == 31)
    		return true;
    	else
    		return false;
    }
    
    //月末校验
    private boolean isEndMonth(Integer year, Integer month, Integer day) {
    	if(month == 2 && (isLeapYear(year) && day == 29 || !isLeapYear(year) && day == 28))
    		return true;
    	else if(month == 4 || month == 6 || month == 9 || month == 11 && day == 30)
    		return true;
    	else if(day == 31)
    		return true;
    	else
    		return false;
    }

}