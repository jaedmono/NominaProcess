package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.Contrato;
import com.smartservice.nomina.process.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contrato, Long> {

    List<Contrato> findByIdEmpresaAndEstadoAndPeriodoPago(long idEmpresa, String estado, String periodoPago);

    Contrato findByEmpleadoAndEstado(Empleado empleado, String estado);

    long countByPeriodoPagoAndEstado(String periodoPago, String estado);
}
