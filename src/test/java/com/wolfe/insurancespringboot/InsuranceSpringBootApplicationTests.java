package com.wolfe.insurancespringboot;

import com.wolfe.insurance.InsuranceSpringBootApplication;
import com.wolfe.insurance.config.SystemConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = InsuranceSpringBootApplication.class)
class InsuranceSpringBootApplicationTests {

	@Autowired
	private SystemConfiguration systemConfiguration;

	@Autowired
	SystemConfiguration systemConfiguration1;

	@Test
	void contextLoads() {
	}


	@Test
	void testConfig() {
		System.out.println(systemConfiguration.getClass().hashCode());
		System.out.println(systemConfiguration1.getClass().hashCode());
		Assertions.assertEquals("gsg", systemConfiguration.getTest());
	}
}
