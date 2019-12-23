package com.bridgelabz.designPattern.creationalDesignPattern.Singleton.EagerInitializedSingleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ImplementationOfEager {

	public static void print(String name, EagerInitialized object) {
		System.out.println(String.format("Object: %s, HashCode: %d", name, object.hashCode()));
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, 
	   InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException {
		EagerInitialized ref1 = EagerInitialized.getInstance();
		EagerInitialized ref2 = EagerInitialized.getInstance();
		print("ref1", ref1);
		print("ref2", ref2);
		Class cls = Class.forName("com.bridgelabz.designPattern.creationalDesignPattern.EagerInitializedSingleton");
		@SuppressWarnings("unchecked")
		Constructor<EagerInitialized> ct = cls.getDeclaredConstructor();
		ct.setAccessible(true);
		EagerInitialized ref3 = ct.newInstance();
		print("ref3", ref3);
		@SuppressWarnings("resource")
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ref2.ser"));
		oos.writeObject(ref2);
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ref2.ser"));
		EagerInitialized ref4 = (EagerInitialized) ois.readObject();
		print("ref4", ref4);
	}
	
}
