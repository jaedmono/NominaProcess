package com.smartservice.nomina.process.service.impl;

import com.smartservice.nomina.process.model.Contrato;
import com.smartservice.nomina.process.model.Empleado;
import com.smartservice.nomina.process.repository.ContractRepository;
import com.smartservice.nomina.process.service.ContractService;
import com.smartservice.nomina.process.util.TypeContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository repository;

    @Override
    public List<Contrato> getAllContratos() {
        return this.repository.findAll();
    }

    @Override
    public Contrato saveContrato(Contrato contrato) {
        return this.repository.save(contrato);
    }

    @Override
    public void deleteContrato(long contratoId) {
        this.repository.delete(contratoId);
    }

    public List<Contrato> getContratosByIdEmpresaAndEstatusAndPeriodoPago(long idEmpresa, String estado, String periodoPago){
        return this.repository.findByIdEmpresaAndEstadoAndPeriodoPago(idEmpresa, estado, periodoPago);
    }

    @Override
    public TypeContract getTypeContract(int type) {
        for (TypeContract typeContract : TypeContract.values()) {
            if(typeContract.getType() == type){
                return typeContract;
            }
        }
        return TypeContract.TERMINO_INDEFINIDO;
    }

    @Override
    public Contrato getContratoByTrabajadorAndEstado(Empleado empleado, String estado) {
        return this.repository.findByEmpleadoAndEstado(empleado, estado);
    }


}
