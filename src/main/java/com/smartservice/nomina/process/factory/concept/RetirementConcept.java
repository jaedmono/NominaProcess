package com.smartservice.nomina.process.factory.concept;

import com.smartservice.nomina.process.model.Concepto;

public class RetirementConcept implements BasicConcept {

    private long totalSalary;

    private Concepto concepto;

    public RetirementConcept(Concepto concepto, long totalSalary){
        this.concepto = concepto;
        this.totalSalary = totalSalary;
    }

    @Override
    public long process() {
        return (long) (totalSalary * concepto.getFactor());
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }


}
