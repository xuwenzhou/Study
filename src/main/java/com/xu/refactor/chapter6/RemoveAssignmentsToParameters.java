package com.xu.refactor.chapter6;

/**
 * 移除对参数的赋值-若代码对一个参数赋值则以一个临时变量取代该参数的位置
 * @author 39767
 *
 */
public class RemoveAssignmentsToParameters {
	
	public int discount(int inputVal, int quantity, int yearToDate){
		if(inputVal > 50) 
			inputVal -= 2;
		if(quantity > 100)
			inputVal -= 1;
		if(yearToDate > 10000)
			inputVal -= 4;
		return inputVal;
	}
	
	public int discount_R(int inputVal, int quantity, int yearToDate){
		int result = inputVal;
		if(inputVal > 50) 
			result -= 2;
		if(quantity > 100)
			result -= 1;
		if(yearToDate > 10000)
			result -= 4;
		return result;
	}
}
