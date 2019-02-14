package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.Nomina;
import com.smartservice.nomina.process.model.PeriodoNomina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayrollRepository extends JpaRepository<Nomina, Long> {

    Page<Nomina> findByEstado(String estado, Pageable pageable);

    List<Nomina> findByIdEmpresaOrderByPeriodoNomina(long idEmpresa);

    Long countByPeriodoNominaAndEstado(PeriodoNomina periodoNomina, String estado);
}
