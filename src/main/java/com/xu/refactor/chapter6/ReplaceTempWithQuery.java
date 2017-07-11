package com.xu.refactor.chapter6;

/**
 * 以查询取代临时变量-将临时变量的赋值表达式提炼为一个独立方法，以消除临时变量
 * @author 39767
 *
 */
public class ReplaceTempWithQuery {
	
	public int quantity = 10;
	public int itemPrice = 100;

	public double calculatePrice() {
		int basePrice = quantity * itemPrice;
		double discountFactor;
		if(basePrice > 1000)
			discountFactor = 0.95;
		else 
			discountFactor = 0.98;
		return basePrice * discountFactor;
	}
	
	public double calculatePrice_R() {
		return calculateBasePrice() * getDiscountFactor();
	}
	
	private int calculateBasePrice(){
		return quantity * itemPrice;
	}
	
	private double getDiscountFactor(){
		if(calculateBasePrice() > 1000)
			return 0.95;
		else
			return 0.98;
	}
}
