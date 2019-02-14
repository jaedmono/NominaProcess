package com.smartservice.nomina.process.factory.concept;

public class InabilityCompany implements BasicConcept {

    private long ibcLastMonth;
    private int daysWorked;

    public InabilityCompany(long ibcLastMonth, int daysWorked ){
        this.ibcLastMonth = ibcLastMonth;
        this.daysWorked = daysWorked;
    }

    @Override
    public long process() {
        return ((ibcLastMonth/30)*2/3)*daysWorked;
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }
}
