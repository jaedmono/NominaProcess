package com.smartservice.nomina.process.service;

import com.smartservice.nomina.process.model.Empleado;

import java.util.List;

public interface EmployeeService {

    List<Empleado> getEmpleados();

    Empleado saveEmpleado(Empleado empleado);

    void deleteEmpleado(long empleadoId);

    Empleado getEmpleadoByDocumento(long documento);

}
