package com.smartservice.nomina.process.service;

import com.smartservice.nomina.process.model.NominaContrato;
import com.smartservice.nomina.process.model.NovedadProgramada;

import java.util.Date;
import java.util.List;

public interface NewsScheduledService {

    List<NovedadProgramada> getAllNovedadesProgramadas();

    NovedadProgramada saveNovedadProgramada(NovedadProgramada novedadProgramada);

    void deleteNovedadProgramada(long novedadProgramadaId);

    void addNovedadesProgramadas(NominaContrato nomina, Date fechaPago);
}
