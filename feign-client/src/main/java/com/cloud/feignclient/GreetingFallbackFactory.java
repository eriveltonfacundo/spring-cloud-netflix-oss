package com.cloud.feignclient;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class GreetingFallbackFactory implements FallbackFactory<GreetingClient> {

	@Override
	public GreetingClient create(Throwable cause) {
		return new GreetingClient() {
			@Override
			public String greeting() {
				return cause.getMessage();
			}
		};
	}
}