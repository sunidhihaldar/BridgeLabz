package com.bridgelabz.Reflection;

public class ReflectionTest {

	private String s;
		
	public ReflectionTest() {
		s = "Hello";
	}
		
	public void method1() {
		System.out.println("The String is " + s);
	}
		
	public void method2(int n) {
		System.out.println("The number is " + n);
	}
		
	@SuppressWarnings("unused")
	private void method3() {
		System.out.println("Private constructor");
	}
}
