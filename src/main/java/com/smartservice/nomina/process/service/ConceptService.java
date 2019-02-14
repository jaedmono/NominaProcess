package com.smartservice.nomina.process.service;

import com.smartservice.nomina.process.model.Concepto;

import java.util.List;

public interface ConceptService {

    List<Concepto> getAllConceptos();

    Concepto saveConcepto(Concepto concepto);

    void deleteConcepto(long conceptoId);

    Concepto getConceptoById(long idConcepto);

    List<Concepto> getUntouchablesConcepts(String clasificacion);

}
