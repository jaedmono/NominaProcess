package com.smartservice.nomina.process.service;

import com.smartservice.nomina.process.exception.PayrollException;
import com.smartservice.nomina.process.model.Nomina;

import java.util.List;

public interface PayrollService {

    List<Nomina> getAllNominas();

    Nomina saveNomina(Nomina nomina);

    Nomina insertNomina(Nomina nomina) throws PayrollException;

    void deleteNomina(long nominaid);

    Nomina findByIdNomina(long nominaid);

    default List<Nomina> findByIdEmpresa(long nominaid) {
        return null;
    }
}
