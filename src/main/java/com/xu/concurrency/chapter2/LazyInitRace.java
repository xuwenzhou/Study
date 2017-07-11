package com.xu.concurrency.chapter2;

import com.xu.concurrency.NotThreadSafe;

/**
 * 2.2.2 懒加载
 * @author 39767
 *
 */
@NotThreadSafe
public class LazyInitRace {
	private ExpensiveObject instance = null;
	
	public ExpensiveObject getInstance(){
		if(instance == null)
			instance = new ExpensiveObject();
		return instance;
	}
	
	private static class ExpensiveObject{
		
	}

}
