package com.bridgelabz.designPattern.structuralDesignPattern.Proxy;

import com.bridgelabz.designPattern.structuralDesignPattern.Proxy.ICommandExecutor;
import com.bridgelabz.designPattern.structuralDesignPattern.Proxy.CommandExecutorProxy;

public class ProxyPatternTest {

	public static void main(String[] args){
		ICommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::"+e.getMessage());
		}
		
	}

}
