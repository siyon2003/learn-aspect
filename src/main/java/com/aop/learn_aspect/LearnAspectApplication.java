package com.aop.learn_aspect;

import com.aop.learn_aspect.aop.business.BusinessService1;
import com.aop.learn_aspect.aop.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnAspectApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private BusinessService1 businessService1;
	private BusinessService2 businessService2;

	public LearnAspectApplication(BusinessService1 businessService1, BusinessService2 businessService2){
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnAspectApplication.class, args);
	}

	@Override // It is used to execute at the startup of the application
	public void run(String... args) throws Exception {
		logger.info("Max number in the list is {}",businessService1.findMaxNumbers("Hacker","batman"));
		logger.info("Min number in the list is {}",businessService2.findMinNumbers("Hacker"));
	}
}
