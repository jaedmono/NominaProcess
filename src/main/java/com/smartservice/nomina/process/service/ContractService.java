package com.smartservice.nomina.process.service;

import com.smartservice.nomina.process.model.Contrato;
import com.smartservice.nomina.process.model.Empleado;
import com.smartservice.nomina.process.util.TypeContract;

import java.util.List;

public interface ContractService {

    List<Contrato> getAllContratos();

    Contrato saveContrato(Contrato contrato);

    void deleteContrato(long contratoId);

    Contrato getContratoByTrabajadorAndEstado(Empleado empleado, String estado);

    List<Contrato> getContratosByIdEmpresaAndEstatusAndPeriodoPago(long idEmpresa, String estado, String periodoPago);

    TypeContract getTypeContract(int type);

}
