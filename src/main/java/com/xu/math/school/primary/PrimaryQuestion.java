package com.xu.math.school.primary;

import com.xu.math.util.Util;

public class PrimaryQuestion {

	//一个自然数的个位是六，如果把个位上的六移动到原自然数的最高位，那么新构成的自然数是原来这个数的三倍。问原来的自然数有多少位。
	public int get(){
	    int top = Util.SIX;
	    int multiplier = Util.THREE;
		int carry = Util.ZERO;
		int index = Util.ZERO;
		
		int result;
		System.out.print(top);
		do{
			result = carry + top * multiplier;
			top = result % 10;
			carry = result / 10;
			index++;
			System.out.print(top);
		}while(top != Util.SIX || carry != 0);
		
		System.out.println();
		return index;
	}
}
