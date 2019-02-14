package com.smartservice.nomina.process.service;

import com.smartservice.nomina.process.model.Descuento;
import com.smartservice.nomina.process.model.NominaContrato;

import java.util.Date;
import java.util.List;

public interface DiscountService {

    List<Descuento> getAllDescuentos();

    Descuento saveDescuento(Descuento descuento);

    void deleteDescuento(long descuentoId);

    void addDescuentos(NominaContrato nominaContrato, Date fechapago);
}
