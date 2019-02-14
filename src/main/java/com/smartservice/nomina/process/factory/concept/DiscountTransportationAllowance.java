package com.smartservice.nomina.process.factory.concept;


public class DiscountTransportationAllowance implements BasicConcept{

    private long transportAllowence;
    private int daysWorked;
    private int days = 30;



    public DiscountTransportationAllowance( int daysWorked, long transportAllowence ){
        this.daysWorked = daysWorked;
        this.transportAllowence = transportAllowence;
    }

    @Override
    public long process() {
        return (transportAllowence/30)*daysWorked;
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }


}
