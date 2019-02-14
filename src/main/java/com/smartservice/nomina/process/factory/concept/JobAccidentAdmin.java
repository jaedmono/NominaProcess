package com.smartservice.nomina.process.factory.concept;

public class JobAccidentAdmin implements BasicConcept {

    private double ibcLastMonth;
    private int days;

    public JobAccidentAdmin(long ibcLastMonth, int days){
        this.days = days;
        this.ibcLastMonth = (double)ibcLastMonth;
    }

    @Override
    public long process() {
        return (long)((ibcLastMonth/30D)*days);
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }
}
