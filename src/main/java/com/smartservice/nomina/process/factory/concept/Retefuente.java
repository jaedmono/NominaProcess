package com.smartservice.nomina.process.factory.concept;

import com.smartservice.nomina.process.model.Concepto;

public class Retefuente implements BasicConcept {

    private long totalSalary;
    private long minimumSalary;

    private Concepto concepto;

    public Retefuente(Concepto concepto, long totalSalary, long minimumSalary) {
        this.concepto = concepto;
        this.totalSalary = totalSalary;
        this.minimumSalary = minimumSalary;
    }

    @Override
    public long process() {
        return (long) (totalSalary * concepto.getFactor());
    }

    @Override
    public boolean isProcessAvailabled() {
        return totalSalary >= minimumSalary*4;
    }

}
