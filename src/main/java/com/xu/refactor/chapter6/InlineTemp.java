package com.xu.refactor.chapter6;

/**
 * 内联临时变量-临时变量只是简单一次赋值时，去掉它
 * @author 39767
 *
 */
public class InlineTemp {
	
	public boolean isOverThousand(){
		double basePrice = basePrice();
		return basePrice > 1000;
	}
	
	private double basePrice(){
		return 1000.0;
	}
	
	public boolean isOverThousand_R() {
		return basePrice() > 1000;
	}
}
