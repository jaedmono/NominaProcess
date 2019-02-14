package com.smartservice.nomina.process.factory.concept;

public class DaysBasicConcept implements BasicConcept {

    private long salary;
    private int daysWorked;

    public DaysBasicConcept(long salary, int daysWorked){
        this.salary = salary;
        this.daysWorked = daysWorked;
    }

    @Override
    public long process() {
        return (salary/30)*daysWorked;
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }
}
