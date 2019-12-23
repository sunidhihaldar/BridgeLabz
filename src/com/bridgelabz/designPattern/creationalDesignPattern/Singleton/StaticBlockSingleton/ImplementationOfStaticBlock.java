package com.bridgelabz.designPattern.creationalDesignPattern.Singleton.StaticBlockSingleton;

public class ImplementationOfStaticBlock {

	public static void print(String name, StaticBlock object) {
		System.out.println(String.format("Object: %s, HashCode: %d", name, object.hashCode()));
	}
	
	public static void main(String[] args) {
		StaticBlock ref1 = StaticBlock.getInstance();
		StaticBlock ref2 = StaticBlock.getInstance();
		print("ref1", ref1);
		print("ref2", ref2);
	}
}
