package com.xu.refactor.chapter6;

/**
 * 内联函数-一个函数的本体与名称同样清楚易懂
 * @author 39767
 *
 */
public class InlineMethod {
	public int numberOfLateDeliveries = 5;
	
	public int getRating(){
		return (moreThanFiveLateDeliveries()) ? 2 : 1;
	}
	
	public boolean moreThanFiveLateDeliveries(){
		return numberOfLateDeliveries > 5;
	}
	
	public int getRateing_R() {
		return (numberOfLateDeliveries > 5) ? 2 : 1;
	}
}
