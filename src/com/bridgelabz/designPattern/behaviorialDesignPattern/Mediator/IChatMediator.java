package com.bridgelabz.designPattern.behaviorialDesignPattern.Mediator;

public interface IChatMediator {

	public void sendMessage(String msg, User user);

	void addUser(User user);
}
