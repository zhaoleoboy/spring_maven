package com.xiao.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeHandler {

	@Before("execution(* do*(..))")
	public void printTime() {
		System.out.println("CurrentTime = " + System.currentTimeMillis());
	}
}