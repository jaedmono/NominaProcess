package com.smartservice.nomina.process.service.impl;

import com.smartservice.nomina.process.exception.PayrollException;
import com.smartservice.nomina.process.model.Nomina;
import com.smartservice.nomina.process.model.PeriodoNomina;
import com.smartservice.nomina.process.repository.ContractRepository;
import com.smartservice.nomina.process.repository.PayrollRepository;
import com.smartservice.nomina.process.service.PayrollService;
import com.smartservice.nomina.process.util.EstadoContrato;
import com.smartservice.nomina.process.util.EstadoNomina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository repository;

    @Autowired
    private ContractRepository contratoRepository;

    @Autowired
    private PayrollContractServiceImpl nominaContratoService;

    @Override
    public List<Nomina> getAllNominas() {
        return this.repository.findAll();
    }

    @Override
    public Nomina saveNomina(Nomina nomina) {
        return this.repository.save(nomina);
    }

    @Override
    public Nomina insertNomina(Nomina nomina)  {
        try {
            this.validateNominaPeriod(nomina.getPeriodoNomina());
            this.validateContracts(nomina.getPeriodoNomina().getTipoNomina());
        } catch (PayrollException e) {
            e.printStackTrace();
        }
        return this.persistNomina(nomina);

    }

    private void validateNominaPeriod(PeriodoNomina periodoPago) throws PayrollException {
        long nominasProceso = repository.countByPeriodoNominaAndEstado(periodoPago, EstadoNomina.EN_PROCESO.toString());
        if(nominasProceso >= 0){
            throw new PayrollException("Ya existe una nomina en proceso para el periodo de tiempo enviado.");
        }
    }

    private void validateContracts(String periodoPago) throws PayrollException {
        long contratosActivos = contratoRepository.countByPeriodoPagoAndEstado(periodoPago, EstadoContrato.ACTIVO.toString());
        if(contratosActivos <= 0){
            throw new PayrollException("No hay contratos activos para lanzar la nomina.");
        }
    }

    private Nomina persistNomina(Nomina nomina) {
        nomina.setEstado(EstadoNomina.PENDIENTE.toString());
        return this.repository.save(nomina);
    }

    @Override
    public void deleteNomina(long nominaid) {
        this.repository.delete(nominaid);
    }

    @Override
    public Nomina findByIdNomina(long nominaId){
        return this.repository.findOne(nominaId);
    }

    @Override
    public List<Nomina> findByIdEmpresa(long idEmpresa) {
        return this.repository.findByIdEmpresaOrderByPeriodoNomina(idEmpresa);
    }
}
