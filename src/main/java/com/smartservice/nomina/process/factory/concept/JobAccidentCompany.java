package com.smartservice.nomina.process.factory.concept;


public class JobAccidentCompany implements BasicConcept {

    private long salary;
    private int days;

    public JobAccidentCompany(long salary, int days){
        this.salary = salary;
        this.days = days;
    }

    @Override
    public long process() {
        return (salary/30)*1;
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }
}
