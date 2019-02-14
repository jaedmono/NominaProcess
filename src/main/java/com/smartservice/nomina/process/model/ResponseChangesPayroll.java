package com.smartservice.nomina.process.model;

import com.smartservice.nomina.process.util.ConceptEnum;

public class ResponseChangesPayroll {

    private String description;
    private String factor;
    private long amount;
    private long value;
    private ConceptEnum typeConceptEnum;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public ConceptEnum getTypeConceptEnum() {
        return typeConceptEnum;
    }

    public void setTypeConceptEnum(ConceptEnum typeConceptEnum) {
        this.typeConceptEnum = typeConceptEnum;
    }
}
