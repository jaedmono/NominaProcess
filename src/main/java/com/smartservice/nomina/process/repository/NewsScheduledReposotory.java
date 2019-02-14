package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.NovedadProgramada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface NewsScheduledReposotory extends JpaRepository<NovedadProgramada, Long> {

    List<NovedadProgramada> findByIdContratoAndEstadoNovedadAndFechaFinalizacionLessThan(long idContrato, String estado, Date fechaFinalizacion);
}
