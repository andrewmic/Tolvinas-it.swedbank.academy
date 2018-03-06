package it.swedbank.domain;

import it.swedbank.util.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

public class Loan {

    private Date creationDate;
    private int termInYears;
    private String name;

    private BigDecimal interest;
    private BigDecimal interestRate;
    private BigDecimal price;
    private BigDecimal totalLoanCost;
    private boolean valid;

    private LoanRiskType riskType;

    public LoanRiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(LoanRiskType riskType) {
        this.riskType = riskType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getTermInYears() {
        return termInYears;
    }

    public void setTermInYears(int termInYears) {
        this.termInYears = termInYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal calculateInterest() {
        return price.multiply(interestRate.divide(new BigDecimal(100)));
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }


    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalLoanCost() {

        return price.add(calculateInterest());
    }

    public void setTotalLoanCost(BigDecimal totalLoanCost) {
        this.totalLoanCost = totalLoanCost;
    }

    public boolean isValid() {

        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
