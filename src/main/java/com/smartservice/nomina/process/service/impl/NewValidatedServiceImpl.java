package com.smartservice.nomina.process.service.impl;

import com.smartservice.nomina.process.batch.processor.NewsProcessor;
import com.smartservice.nomina.process.model.NovedadValidada;
import com.smartservice.nomina.process.repository.NewValidatedRepository;
import com.smartservice.nomina.process.service.NewValidatedService;
import com.smartservice.nomina.process.util.StatusNewsLoaded;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewValidatedServiceImpl implements NewValidatedService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewValidatedServiceImpl.class);

    private static final String IDARCHIVO = "IDARCHIVO";
    private NewValidatedRepository novedadValidadaRepository;
    private NewsProcessor newsProcessor;

    @Autowired
    public NewValidatedServiceImpl(final NewValidatedRepository novedadValidadaRepository, final NewsProcessor newsProcessor){

        this.novedadValidadaRepository = novedadValidadaRepository;
        this.newsProcessor = newsProcessor;

    }

    @Override
    public List<NovedadValidada> getAllNovedadesValidadas() {
        return novedadValidadaRepository.findAll();
    }

    @Override
    public List<NovedadValidada> getAllNovedadesValidadasById(long idArchivoNovedad, String type) {
        List<NovedadValidada> novedadValidadas = new ArrayList<>();
        if(type.equals(IDARCHIVO)){
            novedadValidadas = this.novedadValidadaRepository.findByIdArchivoNovedad(idArchivoNovedad);
        }
        return novedadValidadas;
    }


    @Override
    public NovedadValidada saveNovedadValidada(NovedadValidada novedadValidada) {
        return this.novedadValidadaRepository.save(novedadValidada);
    }

    @Override
    public List<NovedadValidada> saveNovedadValidada(List<NovedadValidada> novedadesValidadas) {
        return this.novedadValidadaRepository.save(novedadesValidadas);
    }

    @Override
    public void deleteNovedadValidada(long idNovedadValidada) {
        this.novedadValidadaRepository.delete(idNovedadValidada);
    }

    @Override
    public NovedadValidada saveNovedadValidada(long idArchivoNovedades, String type, long idEmpresa) {

        List<NovedadValidada> novedadValidadas =
                this.novedadValidadaRepository.findByIdArchivoNovedadAndEstado(idArchivoNovedades, StatusNewsLoaded.VALIDADA.name());
        LOGGER.info("Novedades a procesar: "+novedadValidadas.size());
        this.newsProcessor.loadNovedades(novedadValidadas, idEmpresa);
        return null;
    }


}
