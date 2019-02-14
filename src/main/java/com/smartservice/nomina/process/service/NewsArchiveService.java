package com.smartservice.nomina.process.service;

import com.smartservice.nomina.process.model.ArchivoNovedad;

import java.util.List;

public interface NewsArchiveService {

    List<ArchivoNovedad> getAllArchivoNovedad();

    ArchivoNovedad saveArchivoNovedad(ArchivoNovedad archivoNovedad);

    void deleteArchivoNovedad(long archivoNovedadId);

    void saveArchivoNovedad(int empresaId, String fileName);

    ArchivoNovedad getArchivoNovedadById(long id);
}
