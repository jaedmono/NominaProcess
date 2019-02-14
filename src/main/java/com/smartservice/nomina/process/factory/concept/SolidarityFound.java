package com.smartservice.nomina.process.factory.concept;

import com.smartservice.nomina.process.model.Concepto;

public class SolidarityFound implements BasicConcept {

    private long totalSalaryConcepts;
    private double factor;
    private long minimumSalary;

    public SolidarityFound(long totalSalaryConcepts, Concepto concept, long minimumSalary){
        this.factor = concept.getFactor();
        this.totalSalaryConcepts = totalSalaryConcepts;
        this.minimumSalary = minimumSalary;
    }

    @Override
    public long process() {
        return (long)(totalSalaryConcepts*factor);
    }

    @Override
    public boolean isProcessAvailabled() {
        return totalSalaryConcepts >= minimumSalary*4;
    }
}
