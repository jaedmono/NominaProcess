package com.smartservice.nomina.process.factory.concept;

public class InabilityEPS implements BasicConcept{

    private long salary;
    private int daysWorked;
    private int days = 30;

    public InabilityEPS(long salary, int daysWorked){
        this.salary = salary;
        this.daysWorked = daysWorked;
    }

    @Override
    public long process() {
        if(daysWorked <= 2) {
            return (salary / days) * daysWorked;
        }else{
            return 0;
        }
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }
}
