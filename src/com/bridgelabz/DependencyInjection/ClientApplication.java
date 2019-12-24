package com.bridgelabz.DependencyInjection;

import com.bridgelabz.DependencyInjection.Consumer.IConsumer;
import com.bridgelabz.DependencyInjection.Injector.EmailServiceInjector;
import com.bridgelabz.DependencyInjection.Injector.IMessageServiceInjector;
import com.bridgelabz.DependencyInjection.Injector.SMSServiceInjector;

public class ClientApplication {

	public static void main(String[] args) {
		String msg = "Hello mam";
		String email = "bridgel@gmail.com";
		String phone = "123456789";
		IMessageServiceInjector injector;
		IConsumer app;
		
		//Send email
		injector = new EmailServiceInjector();
		app = injector.getComsumer();
		app.processMessage(msg, email);
		
		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getComsumer();
		app.processMessage(msg, phone);
	}
	
}
