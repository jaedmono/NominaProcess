package com.smartservice.nomina.process.service.impl;

import com.smartservice.nomina.process.model.ArchivoNovedad;
import com.smartservice.nomina.process.model.Empresa;
import com.smartservice.nomina.process.repository.NewsArchiveRepository;
import com.smartservice.nomina.process.service.NewsArchiveService;
import com.smartservice.nomina.process.util.EstadoArchivosNovedad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsArchiveServiceImpl implements NewsArchiveService {

    @Autowired
    private NewsArchiveRepository newsArchiveRepository;


    @Override
    public List<ArchivoNovedad> getAllArchivoNovedad() {
        return  this.newsArchiveRepository.findAll();
    }

    @Override
    public ArchivoNovedad saveArchivoNovedad(ArchivoNovedad archivoNovedad) {
        return this.newsArchiveRepository.save(archivoNovedad);
    }

    @Override
    public void deleteArchivoNovedad(long archivoNovedadId) {
        this.newsArchiveRepository.delete(archivoNovedadId);
    }

    @Override
    public void saveArchivoNovedad(int empresaId, String mombreArchivo) {
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(empresaId);
        ArchivoNovedad archivoNovedad = new ArchivoNovedad();
        archivoNovedad.setNombreArchivo(mombreArchivo);
        archivoNovedad.setEmpresa(empresa);
        archivoNovedad.setFechaCarga(new Date());
        archivoNovedad.setEstado(EstadoArchivosNovedad.CARGADO.toString());
        this.saveArchivoNovedad(archivoNovedad);
    }

    @Override
    public ArchivoNovedad getArchivoNovedadById(long id) {
        return this.newsArchiveRepository.findOne(id);
    }
}
