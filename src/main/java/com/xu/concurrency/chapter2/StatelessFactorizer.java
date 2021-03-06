package com.xu.concurrency.chapter2;

import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.xu.concurrency.ThreadSafe;

/**
 * 2.1.1 无状态对象永远是线程安全的
 * @author 39767
 *
 */
@ThreadSafe
public class StatelessFactorizer extends Chapter2Base implements Servlet {

	public void service(ServletRequest req, ServletResponse resp){
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factory(i);
		encodeIntoResponse(resp, factors);
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
