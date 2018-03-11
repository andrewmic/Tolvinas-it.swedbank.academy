package it.swedbank.domain;

public class CarLoan extends VehicleLoan implements Comparable<CarLoan> {
    private float enginePower;

//
//    public int compareTo(CarLoan loan) {
//        int result = getPrice().compareTo(loan.getPrice());
//        if (this.getPrice().compareTo(loan.getPrice()) == 0) return 1;
//        if (this.getPrice().compareTo(loan.getPrice()) == 0) return 1;
//        if (this.enginePower > getEnginePower()) {
//            return 1;
//        } else if (this.enginePower < getEnginePower()) {
//            return -1;
//        }
//
//
//        //result=this.getEnginePower().compareTo(loan.getEnginePower());
//
//        return result;
//    }


    //Task 5 Test
    public int compareTo(CarLoan o) {

        int compareIndex = o.getPrice().compareTo(getPrice());
        if (compareIndex != 0) return compareIndex;

        compareIndex = ((Float) o.getEnginePower()).compareTo(getEnginePower());
        if (compareIndex != 0) return compareIndex ;

        return getInterestRate().compareTo(o.getInterestRate());
    }

    public float getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(float enginePower) {
        this.enginePower = enginePower;
    }
    //*********


//  –< 0 – when compareThis is lesser than toThis
//  – 0 – when compareThis and toThis are equal
//  –> 0 – when compareThis is grater than toThis

}
