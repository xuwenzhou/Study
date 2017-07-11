package com.xu.refactor.chapter1_refactor;

public abstract class Price {
	protected abstract double price(int daysRented);
	
	protected int point(int daysRented) {
		return 1;
	}
}
