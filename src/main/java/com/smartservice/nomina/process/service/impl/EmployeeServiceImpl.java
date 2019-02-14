package com.smartservice.nomina.process.service.impl;

import com.smartservice.nomina.process.model.Empleado;
import com.smartservice.nomina.process.repository.EmployeeRepository;
import com.smartservice.nomina.process.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Autowired
    EmployeeRepository repository;

    @Override
    public List<Empleado> getEmpleados() {
        List<Empleado> result = repository.findAll();
        return result;
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return repository.saveAndFlush(empleado);
    }

    @Override
    public void deleteEmpleado(long empleadoId) {
        repository.delete(empleadoId);
    }

    @Override
    public Empleado getEmpleadoByDocumento(long numeroDocumento){
        return repository.findByNumeroDocumento(numeroDocumento);
    }


}
