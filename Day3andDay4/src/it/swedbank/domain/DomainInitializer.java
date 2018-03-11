package it.swedbank.domain;

import it.swedbank.domain.Loan;

public interface DomainInitializer {

    Loan[] initializeLoans();

}