package com.bridgelabz.DependencyInjection.Injector;

import com.bridgelabz.DependencyInjection.Consumer.IConsumer;
import com.bridgelabz.DependencyInjection.Consumer.MyApplication;
import com.bridgelabz.DependencyInjection.Service.SMSService;

public class SMSServiceInjector implements IMessageServiceInjector {

	@Override
	public IConsumer getComsumer() {
		return new MyApplication(new SMSService());
	}
}
