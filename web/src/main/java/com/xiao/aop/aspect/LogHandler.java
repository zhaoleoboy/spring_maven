package com.xiao.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogHandler {

	@Before("execution(* print*(..))")
	public void LogBefore() {
		System.out.println("Log before method");
	}

	@After("execution(* com.xiao.aop.HelloWorld.print*(..))")
	public void LogAfter() {
		System.out.println("Log after method");
	}
}