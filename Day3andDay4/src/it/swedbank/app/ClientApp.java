package it.swedbank.app;

import it.swedbank.domain.DomainInitializer;
import it.swedbank.domain.Loan;
import it.swedbank.domain.LoanRiskType;
import it.swedbank.domain.Task3DomainInitializer;
import it.swedbank.service.LoanService;
import it.swedbank.util.LoanUtil;


public class ClientApp {

    public static void main(String[] args) {

        Loan[] loans = getInitializer().initializeLoans();
        LoanService service = new LoanService(loans);


//        printTask1(service);
//        printTask2(service);

        printTask3(service);

    }

    private static void printTask3(LoanService service) {
        System.out.print("LowRiskHarvesterLoans: ");
        System.out.println(service.calculateLowRiskHarvesterLoans().size());

        System.out.print("ExpiredLandLoansInReservation: ");
        System.out.println(service.calculateExpiredLandLoansInReservation());

        System.out.println("LoansOfHigherThanAverageDepreciation: ");
        System.out.print("Count: " + service.calculateLoansOfHigherThanAverageDepreciation().get(0) + " Average: " + service.calculateLoansOfHigherThanAverageDepreciation().get(1));
    }

    private static void printTask2(LoanService service) {
        System.out.print("NormalRiskVehicleLoans ");
        System.out.println(service.calculateNormalRiskLoans((LoanRiskType.NORMAL_RISK)).size());

        System.out.print("MaximumAgeOfLowRiskLoanedVehicles ");
        System.out.println(service.calculateMaximumAgeOfLowRiskLoanedVehicles());

        System.out.print("PersonalRealEstateLoans ");
        System.out.println(service.calculatePersonalRealEstateLoans().size());

        System.out.println("Count: " + service.calculateExpiredHighRiskVehicleLoansOfHighestDuration().size() + " and highest duration: " + service.calculateExpiredHighRiskVehicleLoansOfHighestDuration().get(0).getTermInYears());
    }

    private static void printTask1(LoanService service) {
        System.out.print("HighRiskLoanCount: ");
        System.out.println(service.calculateHighRiskLoans(LoanRiskType.HIGH_RISK).size());

        System.out.print("AverageLoanCost ");
        System.out.println(service.calculateAverageLoanCost());

        System.out.print("NORMAL_RISK: ");
        System.out.println(service.calculateAverageLoanCost(LoanRiskType.NORMAL_RISK));

        System.out.print("HIGH_RISK: ");
        System.out.println(service.calculateAverageLoanCost(LoanRiskType.HIGH_RISK));

        System.out.print("LOW_RISK: ");
        System.out.println(service.calculateAverageLoanCost(LoanRiskType.LOW_RISK));

        System.out.println(service.calculateAverageLoanCost(LoanRiskType.HIGH_RISK));

        System.out.print("MaximumPriceOfNonExpiredLoans: ");
        System.out.println(service.calculateMaximumPriceOfNonExpiredLoans());
    }


    public static DomainInitializer getInitializer() {
        //return new Task1DomainInitializer();
        //return new Task2DomainInitializer();
        return new Task3DomainInitializer();
    }

}