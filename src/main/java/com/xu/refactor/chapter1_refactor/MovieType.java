package com.xu.refactor.chapter1_refactor;

import com.xu.refactor.IEnum;

public enum MovieType implements IEnum {
	REGULAR(0, "一般"),
	NEW_RELEASE(1, "一般"),
	CHILDREN(2, "一般");
	
	private int code;
	private String desc;
	
	MovieType(int code, String desc){
		this.code = code;
		this.desc = desc;
	}
	
	public static MovieType getInstance(int code) {
		for(MovieType movieType :MovieType.values()){
			if(code == movieType.getCode())
				return movieType;
		}
		throw new IllegalArgumentException("Incorrect Price Code");
	}
	
	public static Price getPrice(int code){
		switch (getInstance(code)) {
		case REGULAR:
			return new RegularPrice();
		case NEW_RELEASE:
			return new NewReleasePrice();
		case CHILDREN:
			return new ChildrenPrice();
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
}
