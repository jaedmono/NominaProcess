package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.Concepto;
import com.smartservice.nomina.process.model.NominaNovedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PayrollNewRepository extends JpaRepository<NominaNovedad, Long> {

    List<NominaNovedad> findByIdContratoAndIdNominaIsNull(long idContrato);

    List<NominaNovedad> findByIdContratoAndIdNomina(long idContrato, long idNomina);

    @Query(value="select sum(n.valor) from NominaNovedad n, Concepto c where c.idConcepto = n.concepto.idConcepto and n.idContrato = ? and n.idNomina = ? and c.naturaleza = ?")
    Long sumValueByContratoAndIdNominaAndNaturaleza(long idContrato, long idNomina, String naturaleza);

    @Query(value = "select sum(n.valor) from NominaNovedad n, Concepto c where c.idConcepto = n.concepto.idConcepto and n.idContrato = ? and n.idNomina = ? and c.aplicaSalud = ?")
    long sumValueByIdContratoAndIdNominaAndApplyEPS(long idContrato, long idNomina,  boolean applyEPS);


    @Query(value = "select sum(n.valor) from NominaNovedad n, Concepto c where c.idConcepto = n.concepto.idConcepto and n.idContrato = ? and n.idNomina = ? and c.aplicaPension = ?")
    long sumValueByIdContratoAndIdNominaAndApplyRetire(long idContrato, long idNomina, boolean applyRetire);

    @Query(value = "select distinct(n.concepto) from NominaNovedad n where n.idNomina = ?")
    List<Concepto> getConceptsPayroll(long idNomina);
}
