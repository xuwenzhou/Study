package com.xu.concurrency.chapter2;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xu.concurrency.NotThreadSafe;

/**
 * 
 * @author 39767
 *
 */
@NotThreadSafe
public class UnsafeCountingFactorizer extends Chapter2Base {
	private long count = 0L;
	
	public long getCount(){
		return this.count;
	}
	
	public void service(ServletRequest req, ServletResponse resp) {
		
	}
}
