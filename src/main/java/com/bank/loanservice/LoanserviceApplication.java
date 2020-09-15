package com.bank.loanservice;

import com.bank.loanservice.model.LoanDetails;
import com.bank.loanservice.repository.LoanApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Date;

@SpringBootApplication
@EnableEurekaClient
public class LoanserviceApplication implements CommandLineRunner {
	@Autowired
	LoanApplicationRepo loanApplicationRepo;
	public static void main(String[] args) {
		SpringApplication.run(LoanserviceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		loanApplicationRepo.save(new LoanDetails(null, "1234567890", "Home", 123456L, 7.1, 34, new Date()));
	}

}
