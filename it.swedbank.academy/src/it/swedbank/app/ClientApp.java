package it.swedbank.app;

import it.swedbank.domain.Loan;
import it.swedbank.domain.LoanRiskType;
import it.swedbank.service.LoanService;

public class ClientApp {

    public static void main(String[] args) {

        Loan[] loans = getInitializer().initializeLoans();
        LoanService service = new LoanService(loans);

        printAll(service);
    }

    private static void printAll(LoanService service) {
        System.out.print("HighRiskLoanCount: ");
        System.out.println(service.getHighRiskLoans());

        System.out.print("AverageLoanCost ");
        System.out.println(service.getAverageLoanCost());

        System.out.print("NORMAL_RISK: ");
        System.out.println(service.getAverageLoanCost(LoanRiskType.NORMAL_RISK));

        System.out.print("HIGH_RISK: ");
        System.out.println(service.getAverageLoanCost(LoanRiskType.HIGH_RISK));

        System.out.print("LOW_RISK: ");
        System.out.println(service.getAverageLoanCost(LoanRiskType.LOW_RISK));

        System.out.print("AverageCostOfHighRiskLoans: ");
        service.setAverageCostOfHighRiskLoans(service.getAverageLoanCost(LoanRiskType.HIGH_RISK));
        System.out.println(service.getAverageCostOfHighRiskLoans());

        System.out.print("MaximumPriceOfNonExpiredLoans: ");
        System.out.println(service.getMaximumPriceOfNonExpiredLoans());
    }


    public static DomainInitializer getInitializer() {
        return new Task1DomainInitializer();
    }

}
