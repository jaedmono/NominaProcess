package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.Concepto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConceptRepository extends JpaRepository<Concepto, Long> {
        Concepto findByIdConcepto(long idConcepto);

        List<Concepto> findByClasificacion(String clasificacion);
}
