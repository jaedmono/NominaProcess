package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.ArchivoNovedad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsArchiveRepository extends JpaRepository<ArchivoNovedad, Long> {

    Page<ArchivoNovedad> findByEstadoOrderByFechaCarga(String estado, Pageable pageable);
}
