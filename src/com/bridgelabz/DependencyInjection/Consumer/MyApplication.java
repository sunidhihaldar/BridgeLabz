package com.bridgelabz.DependencyInjection.Consumer;

import com.bridgelabz.DependencyInjection.Service.IMessageService;

public class MyApplication implements IConsumer {

	private IMessageService service ;
	
	public MyApplication(IMessageService ser) {
		this.service = ser;
	}

    @Override
	public void processMessage(String msg, String rec) {
		this.service.sendMessage(msg, rec);
	}
}
