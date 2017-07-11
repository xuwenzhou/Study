package com.xu.concurrency.chapter1;

import com.xu.concurrency.GuardedBy;
import com.xu.concurrency.ThreadSafe;

@ThreadSafe
public class Sequence_2 {
	@GuardedBy("this")
	private int value;
	
	public synchronized int getNext() {
		return value++;
	}
}
