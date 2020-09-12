package com.bank.loanservice;

import com.bank.loanservice.model.LoanDetails;
import com.bank.loanservice.repository.LoanApplicationRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class LoanserviceApplicationTests {

	@InjectMocks
	LoanserviceApplication loanserviceApplication;
	@Mock
	LoanApplicationRepo repository;
	@Test
	void testBankApplicationRun() throws Exception {
		String[] args = {};
		loanserviceApplication.main(args);
		loanserviceApplication.run(args);
		verify(repository, times(1)).save(any(LoanDetails.class));
	}

}
