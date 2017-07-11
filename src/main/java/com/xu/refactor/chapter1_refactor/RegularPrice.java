package com.xu.refactor.chapter1_refactor;

public class RegularPrice extends Price {

	@Override
	public double price(int daysRented) {
		if(daysRented > 2)
			return 2 + (daysRented - 2) * 1.5;
		else 
			return 2;
	}

}
