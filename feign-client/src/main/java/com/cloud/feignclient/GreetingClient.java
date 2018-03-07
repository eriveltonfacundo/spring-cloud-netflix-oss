package com.cloud.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "product-service", fallbackFactory = GreetingFallbackFactory.class)
public interface GreetingClient {

	@RequestMapping("/greeting")
	String greeting();
	
}