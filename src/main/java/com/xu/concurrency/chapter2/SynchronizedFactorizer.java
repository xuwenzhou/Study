package com.xu.concurrency.chapter2;

import java.math.BigInteger;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xu.concurrency.GuardedBy;
import com.xu.concurrency.ThreadSafe;

/**
 * 2.3.1 内部锁
 * @author 39767
 *
 */
@ThreadSafe
public class SynchronizedFactorizer extends Chapter2Base {
	@GuardedBy("this")
	private BigInteger lastNumber;
	
	@GuardedBy("this")
	private BigInteger[] lastFacotrs;
	
	public synchronized void service(ServletRequest req, ServletResponse resp){
		BigInteger i = extractFromRequest(req);
		if(i.equals(lastNumber))
			encodeIntoResponse(resp, lastFacotrs);
		else {
			BigInteger[] factors = factory(i);
			lastNumber = i;
			lastFacotrs = factors;
			encodeIntoResponse(resp, factors);
		}
	}

}
