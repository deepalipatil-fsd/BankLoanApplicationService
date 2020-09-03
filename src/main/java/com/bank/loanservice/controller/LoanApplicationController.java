package com.bank.loanservice.controller;

import com.bank.loanservice.model.LoanDetails;
import com.bank.loanservice.repository.LoanApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan/")
public class LoanApplicationController {
    @Autowired
    LoanApplicationRepo loanApplicationRepo;

    @PostMapping("/apply")
    LoanDetails applyLoan(@RequestBody LoanDetails loanDetails) {
        //Add code to check if user exist with same PAN. Not needed after adding unique constraint on PAN column.
        try{
            return loanApplicationRepo.save(loanDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }
    
    @GetMapping("/loandetails/{accountNumber}")
    List<LoanDetails> getLoanDetails(@PathVariable("accountNumber") String accountNumber) {
        return loanApplicationRepo.findByAccountNumber(accountNumber);
    }

}
