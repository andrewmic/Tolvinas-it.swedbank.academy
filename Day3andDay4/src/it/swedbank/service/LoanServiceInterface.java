package it.swedbank.service;

import it.swedbank.domain.Loan;
import it.swedbank.domain.LoanRiskType;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface LoanServiceInterface {




    //Day3 Tasks 1
    List<Loan> calculateHighRiskLoans(LoanRiskType riskType);
    BigDecimal calculateAverageLoanCost();

    BigDecimal calculateAverageLoanCost(LoanRiskType riskType);

    BigDecimal calculateMaximumPriceOfNonExpiredLoans();

    int calculateMaximumAgeOfLowRiskLoanedVehicles();

    List<Loan> calculatePersonalRealEstateLoans();

    List<Loan> calculateExpiredHighRiskVehicleLoansOfHighestDuration();

    List<Loan> calculateNormalRiskLoans(LoanRiskType riskType);

    //Day4 Task2
    Collection<String> findVehicleModels();

    //Day4 Task3
    Map<LoanRiskType, List<Loan>> groupLoansByRiskType();

    //Day4 Task4
    @Override
    boolean equals(Object o);

    @Override
    int hashCode();




}
