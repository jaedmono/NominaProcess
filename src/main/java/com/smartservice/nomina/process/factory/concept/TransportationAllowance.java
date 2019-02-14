package com.smartservice.nomina.process.factory.concept;

public class TransportationAllowance implements BasicConcept {

    private long transportAllowence;
    private int daysWorked;
    private int days = 30;
    private long salary;
    private long minimumSalary;

    public TransportationAllowance(int daysWorked, long salary, long transportAllowence, long minimumSalary){
        this.daysWorked = daysWorked;
        this.salary = salary;
        this.transportAllowence = transportAllowence;
        this.minimumSalary = minimumSalary;
    }

    @Override
    public long process() {
        return (transportAllowence /days) * daysWorked;
    }

    @Override
    public boolean isProcessAvailabled() {
        return salary <= minimumSalary*2;
    }

}
