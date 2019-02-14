package com.smartservice.nomina.process.factory.concept;

public class License implements BasicConcept {

    private long ibcLastMonth;
    private int daysWorked;

    public License(long ibcLastMonth, int daysWorked){
        this.ibcLastMonth = ibcLastMonth;
        this.daysWorked = daysWorked;
    }

    @Override
    public long process() {
        return (ibcLastMonth/30)*daysWorked;
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }
}
