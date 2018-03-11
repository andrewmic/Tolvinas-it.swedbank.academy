package it.swedbank.domain;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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

    public BigDecimal getTotalLoanCost() {
        return totalLoanCost;
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


    public void setTotalLoanCost(BigDecimal totalLoanCost) {
        this.totalLoanCost = totalLoanCost;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return termInYears == loan.termInYears &&
                valid == loan.valid &&
                Objects.equals(creationDate, loan.creationDate) &&
                Objects.equals(name, loan.name) &&
                Objects.equals(interest, loan.interest) &&
                Objects.equals(interestRate, loan.interestRate) &&
                Objects.equals(price, loan.price) &&
                Objects.equals(totalLoanCost, loan.totalLoanCost) &&
                riskType == loan.riskType;
    }

    @Override
    public int hashCode() {

        return Objects.hash(creationDate, termInYears, name, interest, interestRate, price, totalLoanCost, valid, riskType);
    }
}