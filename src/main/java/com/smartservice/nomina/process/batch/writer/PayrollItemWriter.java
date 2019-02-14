package com.smartservice.nomina.process.batch.writer;

import com.smartservice.nomina.process.model.Nomina;
import com.smartservice.nomina.process.service.PayrollService;
import com.smartservice.nomina.process.util.EstadoNomina;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PayrollItemWriter implements ItemWriter<Nomina> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollItemWriter.class);

    @Autowired
    private PayrollService nominaService;

    @Override
    public void write(List<? extends Nomina> nominas) throws Exception {
        LOGGER.info(String.format("Se van a actualizar %s nominas ",nominas.size()) );
        for (Nomina nomina: nominas ) {
            nomina.setEstado(EstadoNomina.PROCESADA.toString());
            this.nominaService.saveNomina(nomina);
        }
    }
}
