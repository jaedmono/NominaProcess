package com.smartservice.nomina.process.batch.processor;

import com.smartservice.nomina.process.factory.ConceptFactory;
import com.smartservice.nomina.process.factory.concept.BasicConcept;
import com.smartservice.nomina.process.model.Concepto;
import com.smartservice.nomina.process.model.NominaContrato;
import com.smartservice.nomina.process.model.NominaNovedad;
import com.smartservice.nomina.process.model.NovedadValidada;
import com.smartservice.nomina.process.repository.PayrollContractRepository;
import com.smartservice.nomina.process.repository.PayrollNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsProcessor {

    private PayrollNewRepository payrollNewRepository;

    private PayrollContractRepository payrollContractRepository;

    private ConceptFactory conceptFactory;

    @Autowired
    public NewsProcessor( final PayrollNewRepository payrollNewRepository,
                             final PayrollContractRepository payrollContractRepository,
                             final ConceptFactory conceptFactory){
        this.payrollNewRepository = payrollNewRepository;
        this.payrollContractRepository = payrollContractRepository;
        this.conceptFactory = conceptFactory;
    }

    public void loadNovedades(List<NovedadValidada> novedadesValidadas, long idEmpresa) {
        NominaNovedad nominaNovedad;
        List<NominaNovedad> nominaNovedades = new ArrayList<>();
        for (NovedadValidada novedadValidada: novedadesValidadas ) {
            nominaNovedad = new NominaNovedad();
            nominaNovedad.setConcepto(novedadValidada.getConcepto());
            nominaNovedad.setValor(novedadValidada.getValor());
            nominaNovedad.setCantidad(novedadValidada.getCantidad());
            nominaNovedad.setIdContrato(novedadValidada.getIdContrato());
            nominaNovedad.setIdEmpresa(idEmpresa);
            nominaNovedad.setIdNomina(getIdNominaActive(novedadValidada));
            nominaNovedades.add(nominaNovedad);
        }
        this.payrollNewRepository.save(nominaNovedades);
    }

    private long getIdNominaActive(NovedadValidada novedadValidada) {
        return payrollContractRepository.findActivePayrollIdByIdContrato(novedadValidada.getIdContrato());
    }


    public long processsConceptValue(Concepto concepto, int time, NominaContrato nominaContrato){
        BasicConcept basicConcept =  this.conceptFactory.getExecutorConcept(concepto, time, nominaContrato);
        if(basicConcept != null && basicConcept.isProcessAvailabled() ) {
            return basicConcept.process();
        }else{
            return 0;
        }

    }
}
