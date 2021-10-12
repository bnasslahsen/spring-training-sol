package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author bnasslahsen
 */
@Component
public class HelloServiceImpl implements HelloService {

	private HelloProperties helloProperties;

	public HelloServiceImpl(HelloProperties helloProperties) {
		this.helloProperties = helloProperties;
	}

	@Override
	public void sayHello(String message) {
		System.out.println(message  +" " + helloProperties.getMessage());
	}

}
