package com.xu.concurrency;

public @interface GuardedBy {
	public String value() default "";
}
