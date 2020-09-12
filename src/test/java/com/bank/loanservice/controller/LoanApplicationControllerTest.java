package com.bank.loanservice.controller;

import com.bank.loanservice.LoanserviceApplication;
import com.bank.loanservice.model.LoanDetails;
import com.bank.loanservice.repository.LoanApplicationRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = LoanserviceApplication.class)
public class LoanApplicationControllerTest {

	@InjectMocks
	LoanApplicationController controller;
	@Mock
	LoanApplicationRepo repository;

	@Test
	public void testApplyLoan() {
		LoanDetails loanDetails = new LoanDetails();
		Date applicationDate = new Date();
		loanDetails.setAccountNumber("1234567890");
		loanDetails.setApplicationDate(applicationDate);
		loanDetails.setDuration(10);
		loanDetails.setId(123L);
		loanDetails.setLoanAmount(500000L);
		loanDetails.setRateOfInterest(7.1);
		loanDetails.setLoanType("Home");
		when(repository.save(any(LoanDetails.class))).thenReturn(loanDetails);
		LoanDetails loanDetailsFromDB = controller.applyLoan(new LoanDetails());
		Assert.assertNotNull(loanDetailsFromDB);
		Assert.assertEquals(loanDetails.getAccountNumber(),"1234567890");
		Assert.assertEquals(loanDetails.getLoanType(),"Home");
		Assert.assertEquals(loanDetails.getApplicationDate(),applicationDate);
		Assert.assertNotNull(loanDetails.getDuration());
		Assert.assertNotNull(loanDetails.getId());
		Assert.assertNotNull(loanDetails.getLoanAmount());
		Assert.assertNotNull(loanDetails.getRateOfInterest());
	}

	@Test
	public void catchExceptionForLoanApplication() throws Exception {
		when(repository.save(any(LoanDetails.class))).thenThrow(new RuntimeException());
		Assert.assertNull(controller.applyLoan(new LoanDetails()));
	}

	@Test
	public void testGetLoanDetails() {
		List<LoanDetails> loanDetails = new ArrayList<>();
		loanDetails.add(new LoanDetails());
		when(repository.findByAccountNumber(anyString())).thenReturn(loanDetails);
		Assert.assertEquals(1, controller.getLoanDetails("1234567890").size());
	}

}
