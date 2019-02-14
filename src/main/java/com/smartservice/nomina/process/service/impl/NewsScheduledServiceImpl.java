package com.smartservice.nomina.process.service.impl;

import com.smartservice.nomina.process.model.Concepto;
import com.smartservice.nomina.process.model.NominaContrato;
import com.smartservice.nomina.process.model.NominaNovedad;
import com.smartservice.nomina.process.model.NovedadProgramada;
import com.smartservice.nomina.process.repository.NewsScheduledReposotory;
import com.smartservice.nomina.process.service.ConceptService;
import com.smartservice.nomina.process.service.NewsScheduledService;
import com.smartservice.nomina.process.service.PayrollNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsScheduledServiceImpl implements NewsScheduledService {

    @Autowired
    private NewsScheduledReposotory reposotory;

    @Autowired
    private PayrollNewsService payrollNewsService;

    @Autowired
    private ConceptService service;


    @Override
    public List<NovedadProgramada> getAllNovedadesProgramadas() {
        return this.reposotory.findAll();
    }

    @Override
    public NovedadProgramada saveNovedadProgramada(NovedadProgramada novedadProgramada) {
        return this.reposotory.save(novedadProgramada);
    }

    @Override
    public void deleteNovedadProgramada(long novedadProgramadaId) {
        this.reposotory.delete(novedadProgramadaId);
    }

    @Override
    public void addNovedadesProgramadas(NominaContrato nominaContrato, Date fechaPago) {
        List<NovedadProgramada> novedadesProgramadas =
                this.reposotory.findByIdContratoAndEstadoNovedadAndFechaFinalizacionLessThan(nominaContrato.getContrato().getIdContrato(),"A", fechaPago);
        NominaNovedad nominaNovedad = new NominaNovedad();
        Concepto concepto;
        for (NovedadProgramada novedadProgramada:novedadesProgramadas) {
            concepto = service.getConceptoById(novedadProgramada.getIdConcepto());
            nominaNovedad.setConcepto(concepto);
            nominaNovedad.setIdNomina(nominaContrato.getIdNominaContrato());
            nominaNovedad.setCantidad(novedadProgramada.getCantidad());
            nominaNovedad.setValor(novedadProgramada.getValor());
            this.payrollNewsService.saveNominaNovedad(nominaNovedad);
        }

    }
}
