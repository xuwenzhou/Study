package com.xu.refactor.chapter1_refactor;

public class ChildrenPrice extends Price{

	@Override
	public double price(int daysRented) {
		if(daysRented > 3)
			return 1.5 + (daysRented - 3) * 1.5;
		else 
			return 1.5;
	}
}
