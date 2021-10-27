package com.hqs.chargeorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//添加熔断降级注解
@EnableCircuitBreaker
public class ChargeOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChargeOrderServiceApplication.class, args);
    }

}
