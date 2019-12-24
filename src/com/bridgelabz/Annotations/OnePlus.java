package com.bridgelabz.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Called Meta Annotation
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
	String os();
	int version() default 1;
}

@SmartPhone(os = "Android", version = 6)
public class OnePlus {

	String model;
	int screenSize;
	
	public OnePlus(String model, int screenSize) {
		super();
		this.model = model;
		this.screenSize = screenSize;
	}
	
	@Deprecated
	public void colour() {
		System.out.println("Black");
	}
	
}
