package com.smartservice.nomina.process.factory.concept;

public class DeductTransportationConcept implements BasicConcept{

    private long transportation;

    private int days;

    public DeductTransportationConcept(long transportation, int days){
        this.days = days;
        this.transportation = transportation;
    }

    @Override
    public long process() {
        return (transportation/30)*days;
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }
}
