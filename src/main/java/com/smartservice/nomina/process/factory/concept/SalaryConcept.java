package com.smartservice.nomina.process.factory.concept;

public class SalaryConcept implements BasicConcept {

    private long salary;

    private int days;

    public SalaryConcept( long salary, int days){
        this.salary = salary;
        this.days = days;
    }

    @Override
    public long process() {
        double salaryDay = (double)salary/30d;
        return (long) (salaryDay*(double)days);
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }
}
