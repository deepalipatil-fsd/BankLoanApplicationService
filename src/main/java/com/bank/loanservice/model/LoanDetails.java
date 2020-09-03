package com.bank.loanservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LoanDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private String loanType; //Home, Car, Education, Personal
    private Long loanAmount;
    private double rateOfInterest;
    private double duration;
    private Date applicationDate;
}
