package com.smartservice.nomina.process.batch.processor;

import com.smartservice.nomina.process.model.Nomina;
import com.smartservice.nomina.process.model.NominaContrato;
import com.smartservice.nomina.process.service.PayrollContractService;
import com.smartservice.nomina.process.service.PayrollNewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PayrollItemProcessor implements ItemProcessor<Nomina,Nomina> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollItemProcessor.class);

    @Autowired
    private PayrollContractService payrollContractService;

    @Autowired
    private PayrollNewsService payrollNewsService;

    @Override
    public Nomina process(Nomina nomina) throws Exception {
        LOGGER.info("Se va a procesar la "+ nomina);
        List<NominaContrato> nominaContratos =  payrollContractService.createNominaContratos(nomina);
        for (NominaContrato nominaContrato: nominaContratos) {
            payrollNewsService.loadAvailableNovedades(nominaContrato);
            payrollNewsService.loadFinalNews(nomina, nominaContrato);
        }

        return nomina;
    }
}
