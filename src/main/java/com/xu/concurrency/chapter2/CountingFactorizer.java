package com.xu.concurrency.chapter2;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xu.concurrency.ThreadSafe;

@ThreadSafe
public class CountingFactorizer implements Servlet {
	private final AtomicLong count = new AtomicLong();

	public long getCount() {
		return this.count.get();
	}
	
	public void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factory(i);
		//自增并返回结果
		count.incrementAndGet();
		encodeIntoResponse(resp, factors);
	}

	private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
		// TODO Auto-generated method stub
		
	}

	private BigInteger[] factory(BigInteger i) {
		// TODO Auto-generated method stub
		return null;
	}

	private BigInteger extractFromRequest(ServletRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
