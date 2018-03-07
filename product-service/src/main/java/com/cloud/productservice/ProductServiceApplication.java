package com.cloud.productservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
public class ProductServiceApplication {

    @Value("${server.port}")
    private String port;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
    @RequestMapping("/greeting")
    public String greeting() {
        return "Hello from Product Service! Port: " + port;
    }
    
}
