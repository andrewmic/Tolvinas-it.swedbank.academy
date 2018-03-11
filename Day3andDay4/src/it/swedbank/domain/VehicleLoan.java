package it.swedbank.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class VehicleLoan extends Loan {
    private Date manufactured;
    private String model;

    private int age;
    private int maximumAge;


    public void setManufactured(Date manufactured) {
        this.manufactured = manufactured;
    }

    public Date getManufactured() {
        return manufactured;
    }

    public void setManufacturedDate(Date manufactured) {
        this.manufactured = manufactured;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    @Override
    public void setInterestRate(BigDecimal interestRate) {
        if (super.getRiskType() == LoanRiskType.HIGH_RISK) {
            super.setInterestRate(interestRate.multiply(new BigDecimal(1.5)));
        } else if (super.getRiskType() == LoanRiskType.NORMAL_RISK) {
            super.setInterestRate(interestRate.multiply(new BigDecimal(1.0)));
        } else if (super.getRiskType() == LoanRiskType.LOW_RISK) {
            super.setInterestRate(interestRate.multiply(new BigDecimal(0.8)));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleLoan)) return false;
        if (!super.equals(o)) return false;
        VehicleLoan that = (VehicleLoan) o;
        return age == that.age &&
                maximumAge == that.maximumAge &&
                Objects.equals(manufactured, that.manufactured) &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), manufactured, model, age, maximumAge);
    }
}
