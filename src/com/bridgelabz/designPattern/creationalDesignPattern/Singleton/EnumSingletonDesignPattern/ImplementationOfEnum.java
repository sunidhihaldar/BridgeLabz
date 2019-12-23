package com.bridgelabz.designPattern.creationalDesignPattern.Singleton.EnumSingletonDesignPattern;

public class ImplementationOfEnum {

	public static void main(String[] args) {
		EnumSingleton instance1 = EnumSingleton.INSTANCE;
		instance1.i = 5;
		instance1.print();
		System.out.println(instance1.hashCode());
		EnumSingleton instance2 = EnumSingleton.INSTANCE;
		instance2.i = 6;
		instance2.print();
		System.out.println(instance2.hashCode());
	}
	
}
