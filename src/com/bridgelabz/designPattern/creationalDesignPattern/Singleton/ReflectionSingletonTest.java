package com.bridgelabz.designPattern.creationalDesignPattern.Singleton;

import java.lang.reflect.Constructor;

import com.bridgelabz.designPattern.creationalDesignPattern.Singleton.EagerInitializedSingleton.EagerInitialized;

public class ReflectionSingletonTest {

    @SuppressWarnings("rawtypes")
	public static void main(String[] args) {
        EagerInitialized instanceOne = EagerInitialized.getInstance();
        EagerInitialized instanceTwo = null;
        try {
            Constructor[] constructors = EagerInitialized.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitialized) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}
