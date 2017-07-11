package com.xu.concurrency.chapter2;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xu.concurrency.NotThreadSafe;

/**
 * 2.3.0 锁-多状态变量处理
 * @author 39767
 *
 */
@NotThreadSafe
public class UnsafeCachingFactorizer extends Chapter2Base {
	private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
	private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();
	
	public void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		//操作未同步
		if(i.equals(lastNumber.get()))
			encodeIntoResponse(resp, lastFactors.get());
		else {
			BigInteger[] factors = factory(i);
			//操作未同步
			lastNumber.set(i);
			lastFactors.set(factors);
			encodeIntoResponse(resp, factors);
		}
	}
}
