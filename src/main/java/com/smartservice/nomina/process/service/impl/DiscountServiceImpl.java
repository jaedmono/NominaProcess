package com.smartservice.nomina.process.service.impl;

import com.smartservice.nomina.process.model.Concepto;
import com.smartservice.nomina.process.model.Descuento;
import com.smartservice.nomina.process.model.NominaContrato;
import com.smartservice.nomina.process.model.NominaNovedad;
import com.smartservice.nomina.process.repository.DiscountRepository;
import com.smartservice.nomina.process.service.ConceptService;
import com.smartservice.nomina.process.service.DiscountService;
import com.smartservice.nomina.process.service.PayrollNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository repository;

    @Autowired
    private ConceptService conceptService;

    @Autowired
    private PayrollNewsService payrollNewsService;


    @Override
    public List<Descuento> getAllDescuentos() {
        return this.repository.findAll();
    }

    @Override
    public Descuento saveDescuento(Descuento descuento) {
        return this.repository.save(descuento);
    }

    @Override
    public void deleteDescuento(long descuentoId) {
        this.repository.delete(descuentoId);
    }

    @Override
    public void addDescuentos(NominaContrato nominaContrato, Date fechapago) {
        List<Descuento> descuentos =
                this.repository.findByIdContratoAndEstadoAndFechaFinalizacionLessThan(nominaContrato.getContrato().getIdContrato(),"A", fechapago);
        NominaNovedad nominaNovedad = new NominaNovedad();
        Concepto concepto ;
        for (Descuento descuento:descuentos) {
            concepto = conceptService.getConceptoById(descuento.getIdConcepto());
            nominaNovedad.setConcepto(concepto);
            nominaNovedad.setIdNomina(nominaContrato.getIdNominaContrato());
            nominaNovedad.setCantidad(1);
            nominaNovedad.setValor(descuento.getTotalDescuento()/descuento.getNumeroCuentas());
            this.payrollNewsService.saveNominaNovedad(nominaNovedad);
        }
    }
}
