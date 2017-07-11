package com.xu.refactor.chapter1_refactor;

public class Movie {
	
	private String title;//电影名
	private int priceCode;//价格编码
	private Price price;//计费方式
	
	public Movie(String title, int priceCode){
		this.title = title;
		this.priceCode = priceCode;
		this.price = MovieType.getPrice(priceCode);
	}
	
	public double charge(int daysRented) {
		return this.price.price(daysRented);
	}
	
	public int point(int daysRented) {
		return this.price.point(daysRented);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	
}
