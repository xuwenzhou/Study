package com.xu.refactor.chapter1_refactor;

public class NewReleasePrice extends Price {

	@Override
	public double price(int daysRented) {
		return daysRented * 3;
	}

	@Override
	protected int point(int daysRented) {
		if(daysRented > 1)
			return 2;
		else 
			return 1;
	}
}
