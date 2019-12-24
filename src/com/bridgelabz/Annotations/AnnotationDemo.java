package com.bridgelabz.Annotations;

import java.lang.annotation.Annotation;

public class AnnotationDemo {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		OnePlus obj = new OnePlus("OS" , 5);
		Class cls = obj.getClass();
		Annotation an = cls.getAnnotation(SmartPhone.class);
		SmartPhone sp = (SmartPhone)an;
		System.out.println(sp.os());
		System.out.println(sp.version());
	}
}
