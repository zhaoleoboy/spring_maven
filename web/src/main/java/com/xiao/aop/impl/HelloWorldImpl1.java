package com.xiao.aop.impl;

import com.xiao.aop.HelloWorld;

public class HelloWorldImpl1 implements HelloWorld {
	public void printHelloWorld() {
		System.out.println("Enter HelloWorldImpl1.printHelloWorld()");
	}

	public void doPrint() {
		System.out.println("Enter HelloWorldImpl1.doPrint()");
		return;
	}
}