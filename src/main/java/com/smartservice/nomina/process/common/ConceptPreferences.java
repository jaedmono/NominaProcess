package com.smartservice.nomina.process.common;

import com.smartservice.nomina.process.model.Concepto;
import com.smartservice.nomina.process.service.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class ConceptPreferences {

    @Autowired
    private ConceptService conceptService;

    private Map<Long, Concepto> conceptsById;

    @PostConstruct
    private void loadDatabaseConcepts(){
        List<Concepto> conceptos = conceptService.getAllConceptos();
        loadConceptsById(conceptos);
    }


    private void loadConceptsById(List<Concepto> conceptos) {
        conceptsById = new HashMap<>();
        conceptos.forEach(c->{conceptsById.put(c.getIdConcepto(),c);});
    }

    public Map<Long, Concepto> getConceptsById() {
        return conceptsById;
    }

    public Concepto getConceptoByClase(String clase){
        AtomicReference<Concepto> concepto = null;
        conceptsById.entrySet().forEach(c->{
            if(clase.equals(c.getValue().getClase())){
                concepto.set(c.getValue());
            }
        });
        return concepto.get();
    }
}
