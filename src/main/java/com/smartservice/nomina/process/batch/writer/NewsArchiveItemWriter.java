package com.smartservice.nomina.process.batch.writer;

import com.smartservice.nomina.process.model.ArchivoNovedadContent;
import com.smartservice.nomina.process.service.NewValidatedService;
import com.smartservice.nomina.process.service.NewsArchiveService;
import com.smartservice.nomina.process.util.EstadoArchivosNovedad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsArchiveItemWriter implements ItemWriter<ArchivoNovedadContent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsArchiveItemWriter.class);

    @Autowired
    private NewValidatedService novedadValidadaService;

    @Autowired
    private NewsArchiveService archivoNovedadesService;

    @Override
    public void write( List<? extends ArchivoNovedadContent> items) throws Exception {
        LOGGER.info(String.format("Se van a registrar %s items ",items.size()) );
        for (ArchivoNovedadContent novedadContent: items ) {
            novedadValidadaService.saveNovedadValidada(novedadContent.getNovedadValidadas());
            novedadContent.getArchivoNovedad().setEstado(EstadoArchivosNovedad.VALIDADO.toString());
            archivoNovedadesService.saveArchivoNovedad(novedadContent.getArchivoNovedad());
        }


    }
}
