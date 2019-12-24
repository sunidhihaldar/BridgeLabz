package com.bridgelabz.DependencyInjection.Service;

public class EmailService implements IMessageService {

	@Override
	public void sendMessage(String message, String receiver) {
	    //logic to send email
		System.out.println("Email sent to " + receiver + " with message = " + message);
	}

}
