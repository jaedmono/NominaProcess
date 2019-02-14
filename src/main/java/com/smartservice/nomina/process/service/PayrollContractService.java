package com.smartservice.nomina.process.service;

import com.smartservice.nomina.process.model.Nomina;
import com.smartservice.nomina.process.model.NominaContrato;
import com.smartservice.nomina.process.model.ResponseNominaContrato;

import java.util.List;

public interface PayrollContractService {

    List<NominaContrato> getAllNominaContrato();

    NominaContrato saveNominaContrato(NominaContrato nominaContrato);

    void deleteNominaContrato(long nominaContratoId);

    List<NominaContrato> createNominaContratos(Nomina nomina);

    List<ResponseNominaContrato> getNominaContratosByIdNomina(long idNomina);

    long findIbcLastMonth(long idContrato);
}
