package com.bridgelabz.DependencyInjection.Service;

public class SMSService implements IMessageService {

	@Override
	public void sendMessage(String message, String receiver) {
		//logic to send SMS
		System.out.println("SMS sent to " + receiver + " with message = " + message);
	}

}
