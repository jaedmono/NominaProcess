package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Empleado,Long> {

    Empleado findByNumeroDocumento(long numeroDocumento);
}
