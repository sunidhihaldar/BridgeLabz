package com.bridgelabz.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Implementation {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {
		ReflectionTest obj = new ReflectionTest();
		
		Class cls =obj.getClass();
		System.out.println("The name of the class is " + cls.getName());
		
		Constructor constructor = cls.getConstructor();
		System.out.println("The name of the constructor is " +  constructor.getName());
		
		System.out.println("The public methods are: ");
		Method[] method = cls.getMethods();
		for(Method methods : method) {
			System.out.println(methods.getName());
		}
		Method methodCall1 = cls.getDeclaredMethod("method2", int.class);
		methodCall1.invoke(obj, 16);
		
		Field field = cls.getDeclaredField("s");
		field.setAccessible(true);
		field.set(obj, "JAVA");
		
		Method methodCall2 = cls.getDeclaredMethod("method1");
		methodCall2.invoke(obj);
		
		Method methodCall3 = cls.getDeclaredMethod("method3");
		methodCall3.setAccessible(true);
		methodCall3.invoke(obj);
	}

}
