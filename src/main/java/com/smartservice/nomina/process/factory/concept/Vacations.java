package com.smartservice.nomina.process.factory.concept;

public class Vacations implements BasicConcept {

    private long averageSalary;
    private int days;

    public Vacations(long averageSalary, int days){
        this.days = days;
        this.averageSalary = averageSalary;
    }

    @Override
    public long process() {
        return (averageSalary/30)*days;
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }
}
