package com.smartservice.nomina.process.service.impl;

import com.smartservice.nomina.process.model.Concepto;
import com.smartservice.nomina.process.repository.ConceptRepository;
import com.smartservice.nomina.process.service.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConceptServiceImpl implements ConceptService {

    @Autowired
    private ConceptRepository repository;


    @Override
    public List<Concepto> getAllConceptos() {
        return this.repository.findAll();
    }

    @Override
    public Concepto saveConcepto(Concepto concepto) {
        return this.repository.save(concepto);
    }

    @Override
    public void deleteConcepto(long conceptoId) {
        this.repository.delete(conceptoId);
    }

    @Override
    public Concepto getConceptoById(long idConcepto){
        return repository.findByIdConcepto(idConcepto);
    }

    @Override
    public List<Concepto> getUntouchablesConcepts(String clasificacion) {
        return repository.findByClasificacion(clasificacion);
    }
}
