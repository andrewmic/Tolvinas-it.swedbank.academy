package it.swedbank.app;

import it.swedbank.domain.Loan;

public interface DomainInitializer {

    Loan[] initializeLoans();

}
