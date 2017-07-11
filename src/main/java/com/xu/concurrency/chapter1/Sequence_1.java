package com.xu.concurrency.chapter1;

import com.xu.concurrency.NotThreadSafe;

@NotThreadSafe
public class Sequence_1 {
	private int value;
	
	public int getNext() {
		return value++;
	}
}
