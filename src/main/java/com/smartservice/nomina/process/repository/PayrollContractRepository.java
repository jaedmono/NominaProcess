package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.NominaContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PayrollContractRepository extends JpaRepository<NominaContrato, Long> {

    List<NominaContrato> findByIdNomina(long idNomina);

    @Query(value = "select distinct(n.totalDevengado) from NominaContrato n where n.contrato.idContrato = ? order by 1 desc")
    long findByIdContratoLastAccrued(long idContrato);

    @Query(value = "select nc.idNomina from NominaContrato nc, Nomina n where nc.idNomina = n.idNomina and n.estado = 'PROCESADA' and nc.contrato.idContrato = ? ")
    long findActivePayrollIdByIdContrato(long idContrato);

    @Query(value = "select n from NominaContrato n where n.idNomina = ? and n.contrato.idContrato = ? ")
    NominaContrato findByIdNominaAndIdContrato(long idNomina, long idContrato);
}
