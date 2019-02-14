package com.smartservice.nomina.process.factory.concept;

import com.smartservice.nomina.process.model.Concepto;
import com.smartservice.nomina.process.model.NominaContrato;

public class ExtraHour implements BasicConcept {

    private long salary;
    private int hours;
    private double factor;
    private int journal;

    public ExtraHour(Concepto concepto, NominaContrato nominaContrato, int hours){
        this.salary = nominaContrato.getContrato().getSueldo();
        this.hours = hours;
        this.factor = concepto.getFactor();
        this.journal = nominaContrato.getContrato().getJornada();
    }

    @Override
    public long process() {
        return (long)(((salary/journal)*hours)*factor);
    }

    @Override
    public boolean isProcessAvailabled() {
        return true;
    }
}
