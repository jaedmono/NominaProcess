package com.smartservice.nomina.process.repository;

import com.smartservice.nomina.process.model.NovedadValidada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewValidatedRepository extends JpaRepository<NovedadValidada, Long> {
    List<NovedadValidada> findByIdArchivoNovedad(long idArchivoNovedad);
    List<NovedadValidada> findByIdArchivoNovedadAndEstado(long idArchivoNovedad, String estado);
}
