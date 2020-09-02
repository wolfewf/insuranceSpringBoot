package com.wolfe.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author wolfe
 */
@SpringBootApplication
public class InsuranceSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceSpringBootApplication.class, args);
	}

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Bean
	public void init(){
		stringRedisTemplate.opsForValue().set("stock","99");
	}
	
	

}
