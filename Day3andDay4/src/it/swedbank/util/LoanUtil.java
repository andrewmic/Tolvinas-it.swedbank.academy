package it.swedbank.util;

import it.swedbank.domain.Loan;
import it.swedbank.domain.VehicleLoan;
import it.swedbank.service.LoanService;
import it.swedbank.util.DateUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class LoanUtil {

    public static long  calculateVehicleYearsInUse(Date manufacturedDate)
    {
        return (DateUtil.differenceInDays(new Date(), manufacturedDate))/365;
    }
    public static BigDecimal calculateVehicleDepreciation(VehicleLoan aLoan) {
        long yearsInUse = calculateVehicleYearsInUse(aLoan.getManufactured());
        BigDecimal maximumAge = new BigDecimal(aLoan.getMaximumAge());
        return aLoan.getPrice().multiply(new BigDecimal(yearsInUse)).divide(maximumAge,2, RoundingMode.HALF_UP);
    }


    public static boolean isValid(Loan aLoan) {
        return DateUtil.addYears(aLoan.getCreationDate(), aLoan.getTermInYears()).after(new Date());
    }



}
