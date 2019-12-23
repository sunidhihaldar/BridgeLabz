package com.bridgelabz.designPattern.structuralDesignPattern.Adapter;

public class Socket {

	public Volt getVolt(){
		return new Volt(120);
	}
}
