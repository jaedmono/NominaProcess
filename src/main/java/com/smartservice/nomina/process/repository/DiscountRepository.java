package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.Descuento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DiscountRepository extends JpaRepository<Descuento, Long> {

    List<Descuento> findByIdContratoAndEstadoAndFechaFinalizacionLessThan(long idContrato, String estado, Date fechaFinalizacion);
}
