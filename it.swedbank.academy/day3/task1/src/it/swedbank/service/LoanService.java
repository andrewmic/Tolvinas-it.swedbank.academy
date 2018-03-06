package it.swedbank.service;

import it.swedbank.domain.Loan;
import it.swedbank.domain.LoanRiskType;
import it.swedbank.util.DateUtil;

import java.math.BigDecimal;
import java.util.Date;

public class LoanService {


    private Loan[] loan;
    //private BigDecimal averageLoanCost;
    private BigDecimal averageCostOfHighRiskLoans;
    //private BigDecimal maximumPriceOfNonExpiredLoans;


    public LoanService(Loan[] loan) {
        this.loan = loan;
    }

//    public Loan[] getLoan() {
//        return loan;
//    }

    public int getHighRiskLoans() {
        int count = 0;
        for (int i = 0; i < loan.length; i++) {
            if (loan[i].getRiskType() == LoanRiskType.HIGH_RISK) {
                count++;
            }
        }
        return count;
    }

    public BigDecimal getAverageLoanCost() {
        BigDecimal averageLoanCost = BigDecimal.ZERO;
        for (int i = 0; i < loan.length; i++) {
            averageLoanCost = averageLoanCost.add(loan[i].getTotalLoanCost());
        }
        return averageLoanCost.divide(BigDecimal.valueOf(loan.length));
    }

    public BigDecimal getAverageLoanCost(LoanRiskType riskType) {
        int tempI = 0;
        BigDecimal averageNormalRiskCost = BigDecimal.ZERO;
        for (int i = 0; i < loan.length; i++) {
            if (loan[i].getRiskType() == riskType) {
                averageNormalRiskCost = averageNormalRiskCost.add(loan[i].getTotalLoanCost());
                tempI++;
            }
        }
        return averageNormalRiskCost.divide(BigDecimal.valueOf(tempI));
    }


    public void setAverageCostOfHighRiskLoans(BigDecimal averageCostOfHighRiskLoans) {
        this.averageCostOfHighRiskLoans = averageCostOfHighRiskLoans;
    }

    public BigDecimal getAverageCostOfHighRiskLoans() {
        return averageCostOfHighRiskLoans;
    }

    public BigDecimal getMaximumPriceOfNonExpiredLoans() {
        BigDecimal maxPrice = BigDecimal.ZERO;
        Date tempa = DateUtil.getDateFromString("2018-03-06");
        for (int i = 0; i < loan.length; i++) {
            Date tempD = DateUtil.addYears(loan[i].getCreationDate(), loan[i].getTermInYears());
            if (DateUtil.differenceInDays(tempD, tempa) > 0)//non expired
            {
                if (maxPrice.compareTo(loan[i].getPrice()) < 0) {
                    maxPrice = loan[i].getPrice();
                }
            }
        }
        return maxPrice;
    }
}
