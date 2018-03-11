package it.swedbank.service;

import it.swedbank.domain.*;
import it.swedbank.util.DateUtil;
import it.swedbank.util.LoanUtil;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LoanService implements LoanServiceInterface {

    private List<Loan> loan;

    //Day3 Tasks 1
    @Override
    public List<Loan> calculateHighRiskLoans(LoanRiskType riskType) {
        // modified for Day3 Task 2 , ex 1
        List<Loan> loansByRiskType = new ArrayList<>();
        for (Loan aLoan : loan) {
            if (aLoan.getRiskType() == riskType) {
                loansByRiskType.add(aLoan);
            }
        }
        return loansByRiskType;
    }

    @Override
    public BigDecimal calculateAverageLoanCost() {
        BigDecimal averageLoanCost = BigDecimal.ZERO;
        for (Loan aLoan : loan) {
            averageLoanCost = averageLoanCost.add(calculateTotalLoanCost(aLoan));
        }
        return averageLoanCost.divide(BigDecimal.valueOf(loan.size()));
    }


    @Override
    public BigDecimal calculateAverageLoanCost(LoanRiskType riskType) {
        int tempI = 0;
        BigDecimal averageNormalRiskCost = BigDecimal.ZERO;
        for (Loan aLoan : loan) {
            if (aLoan.getRiskType() == riskType) {
                averageNormalRiskCost = averageNormalRiskCost.add(calculateTotalLoanCost(aLoan));
                tempI++;
            }
        }
        return averageNormalRiskCost.divide(BigDecimal.valueOf(tempI));
    }

    @Override
    public BigDecimal calculateMaximumPriceOfNonExpiredLoans() {
        BigDecimal maximumPriceOfNonExpiredLoans = BigDecimal.ZERO;
        for (Loan aLoan : loan) {
            if (maximumPriceOfNonExpiredLoans.compareTo(aLoan.getPrice()) < 0) {
                if (LoanUtil.isValid(aLoan)) {
                    maximumPriceOfNonExpiredLoans = aLoan.getPrice();
                }
            }
        }
        return maximumPriceOfNonExpiredLoans;
    }

    private BigDecimal calculateTotalLoanCost(Loan loan) {
        return loan.getPrice().add(loan.getPrice().multiply(loan.getInterestRate().divide(new BigDecimal(100))));
    }
//************


    //Day 3 Task2


    @Override
    public List<Loan> calculateNormalRiskLoans(LoanRiskType riskType) {
        List<Loan> loansByRiskType = new ArrayList<>();
        for (Loan aLoan : loan) {
            if (aLoan instanceof VehicleLoan && aLoan.getRiskType() == riskType) {
                loansByRiskType.add(aLoan);
            }
        }
        return loansByRiskType;
    }

    @Override
    public int calculateMaximumAgeOfLowRiskLoanedVehicles() {
        int maxAge = 0;
        for (Loan aLoan : loan) {
            if (aLoan instanceof VehicleLoan && aLoan.getRiskType().equals(LoanRiskType.LOW_RISK)) {
                if ((int) DateUtil.differenceInDays(new Date(), ((VehicleLoan) aLoan).getManufactured()) / 365 > maxAge) {
                    maxAge = (int) DateUtil.differenceInDays(new Date(), ((VehicleLoan) aLoan).getManufactured()) / 365;
                }
            }
        }
        return maxAge;
    }


    @Override
    public List<Loan> calculatePersonalRealEstateLoans() {
        List<Loan> personalRealEstateLoans = new ArrayList<>();
        for (Loan aLoan : loan) {
            if (aLoan instanceof RealEstateLoan && ((RealEstateLoan) aLoan).getPurpose().equals(RealEstatePurpose.PERSONAL)) {
                personalRealEstateLoans.add(aLoan);
            }
        }
        return personalRealEstateLoans;
    }

    @Override
    public List<Loan> calculateExpiredHighRiskVehicleLoansOfHighestDuration() {
        List<Loan> expiredHighRiskVehicleLoans = new ArrayList<>();
        int maxDuration = 0;
        for (Loan aLoan : loan) {
            if (aLoan instanceof VehicleLoan && aLoan.getRiskType() == LoanRiskType.HIGH_RISK && aLoan.getTermInYears() >= maxDuration && !LoanUtil.isValid(aLoan)) {
                maxDuration = aLoan.getTermInYears();
            }
        }
        for (Loan aLoan : loan) {
            if (aLoan.getTermInYears() == maxDuration) {
                expiredHighRiskVehicleLoans.add(aLoan);
            }
        }
        return expiredHighRiskVehicleLoans;
    }


//    ************

    //Day3 Task3
    public List<Loan> calculateLowRiskHarvesterLoans() {
        List<Loan> lowRiskHarvesterLoans = new ArrayList<>();
        for (Loan aLoan : loan) {
            if (aLoan instanceof HarvesterLoan && aLoan.getRiskType().equals(LoanRiskType.LOW_RISK)) {
                lowRiskHarvesterLoans.add(aLoan);
            }
        }
        return lowRiskHarvesterLoans;
    }

    public List<Loan> calculateExpiredLandLoansInReservation() {
        List<Loan> expiredLandLoansInReservation = new ArrayList<>();
        for (Loan aLoan : loan) {
//?? what im supposed to do ??
        }
        return expiredLandLoansInReservation;
    }

    public List<BigDecimal> calculateLoansOfHigherThanAverageDepreciation() {
        BigDecimal averageDepreciation = BigDecimal.ZERO;
        List<BigDecimal> array = new ArrayList<>();
        int count = 0;
        for (Loan aLoan : loan) {
            if (aLoan instanceof VehicleLoan) {
                if (LoanUtil.calculateVehicleDepreciation((VehicleLoan) aLoan).compareTo(aLoan.getPrice()) > 0) {
                    averageDepreciation = averageDepreciation.add(aLoan.getPrice());
                    array.add(aLoan.getPrice());
                } else if (LoanUtil.calculateVehicleDepreciation((VehicleLoan) aLoan).compareTo(aLoan.getPrice()) < 0) {
                    averageDepreciation = averageDepreciation.add(LoanUtil.calculateVehicleDepreciation((VehicleLoan) aLoan));
                    array.add(LoanUtil.calculateVehicleDepreciation((VehicleLoan) aLoan));
                }
            }
        }
        averageDepreciation = averageDepreciation.divide(new BigDecimal(array.size()));
        for (int i = 0; i < array.size(); i++) {
            if (averageDepreciation.compareTo(array.get(i)) > 0) {
                count++;
            }
        }
        array.add(0, new BigDecimal(count));
        array.add(1, averageDepreciation);
        return array;
    }


    //Day4 Task2
    @Override
    public Collection<String> findVehicleModels() {
        Set<String> vehicleModels = new HashSet<String>();

        for (Loan aLoan : loan) {
            if (aLoan instanceof VehicleLoan) {
                vehicleModels.add(((VehicleLoan) aLoan).getModel());
            }

        }
        return vehicleModels;
    }
//******


    //Day4 Task3
    @Override
    public Map<LoanRiskType, List<Loan>> groupLoansByRiskType() {
        Map<LoanRiskType, List<Loan>> loansByRiskType = new HashMap<>();
        for (Loan aLoan : loan) {
            if (!loansByRiskType.containsKey(aLoan.getRiskType())) {
                loansByRiskType.put(aLoan.getRiskType(), new ArrayList<>());
            }
            loansByRiskType.get(aLoan.getRiskType()).add(aLoan);
        }
        return loansByRiskType;
    }
//********

    public LoanService(Loan[] loan) {
        this.loan = Arrays.asList(loan);
    }

    //Day4 Task4
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoanService)) return false;
        LoanService that = (LoanService) o;
        return Objects.equals(loan, that.loan);
    }

    @Override
    public int hashCode() {

        return Objects.hash(loan);
    }
    //**********
}