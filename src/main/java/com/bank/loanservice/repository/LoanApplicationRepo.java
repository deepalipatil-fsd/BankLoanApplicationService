package com.bank.loanservice.repository;

import com.bank.loanservice.model.LoanDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanApplicationRepo extends CrudRepository<LoanDetails, String> {
    List<LoanDetails> findByAccountNumber(String userName);
}
