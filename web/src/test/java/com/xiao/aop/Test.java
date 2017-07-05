package com.xiao.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@org.junit.Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-aop.xml");

		HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImpl1");
		HelloWorld hw2 = (HelloWorld) ctx.getBean("helloWorldImpl2");
		hw1.printHelloWorld();
		System.out.println();
		hw1.doPrint();

		System.out.println();
		hw2.printHelloWorld();
		System.out.println();
		hw2.doPrint();

	}

}
