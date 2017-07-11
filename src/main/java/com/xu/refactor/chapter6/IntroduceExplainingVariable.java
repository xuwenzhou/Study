package com.xu.refactor.chapter6;

/**
 * 引入解释性变量-将复杂表达式的结果放进临时变量，而不是直接使用改表达式
 * 1.表达式可能很复杂，难以阅读
 * @author 39767
 *
 */
public class IntroduceExplainingVariable {
	public int quantity;
	public int itemPrice;
	
	public double price(){
		return quantity * itemPrice - Math.max(0, quantity - 500) * itemPrice * 0.05 +
				Math.min(quantity * itemPrice * 0.1, 100.0);
	}
	
	public double price_R() {
		//复杂表达式用临时变量拆解
		final double basePrice = quantity * itemPrice;
		final double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05;
		final double less = Math.min(basePrice, 1000) / 10;
		return basePrice - quantityDiscount + less;
	}
	
	public double price_RR(){
		//函数更通用
		return basePrice() - quantityDiscount() + shipping();
	}
	
	private double basePrice(){
		return quantity * itemPrice;
	}
	
	private double quantityDiscount(){
		return Math.max(0, quantity - 500) * itemPrice * 0.05;
	}
	
	private double shipping(){
		return Math.min(basePrice(), 1000) / 10;
	}
}
