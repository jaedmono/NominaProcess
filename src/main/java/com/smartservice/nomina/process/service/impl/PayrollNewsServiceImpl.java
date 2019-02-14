package com.smartservice.nomina.process.service.impl;

import com.smartservice.nomina.process.batch.processor.NewsProcessor;
import com.smartservice.nomina.process.common.ConceptPreferences;
import com.smartservice.nomina.process.model.*;
import com.smartservice.nomina.process.repository.PayrollContractRepository;
import com.smartservice.nomina.process.repository.PayrollNewRepository;
import com.smartservice.nomina.process.service.ConceptService;
import com.smartservice.nomina.process.service.ContractService;
import com.smartservice.nomina.process.service.PayrollNewsService;
import com.smartservice.nomina.process.util.ConceptEnum;
import com.smartservice.nomina.process.util.PeriodoPago;
import com.smartservice.nomina.process.util.TypeContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollNewsServiceImpl implements PayrollNewsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollNewsServiceImpl.class);

    private static final String UNTOUCHABLES = "intocable";

    @Autowired
    private PayrollNewRepository repository;

    @Autowired
    private ConceptService conceptService;

    @Autowired
    private NewsProcessor newsProcessor;

    @Autowired
    private ConceptPreferences conceptPreferences;

    @Autowired
    private PayrollContractRepository payrollContractRepository;

    @Override
    public List<NominaNovedad> getAllNominaNovedad() {
        return this.repository.findAll();
    }

    @Override
    public NominaNovedad saveNominaNovedad(NominaNovedad nominaNovedad) {
        setValueChange(nominaNovedad);
        return this.repository.save(nominaNovedad);
    }

    private void setValueChange(NominaNovedad nominaNovedad) {
        LOGGER.info("noimina");
        if(nominaNovedad.getValor() <= 0 && nominaNovedad.getIdNomina() > 0) {
            NominaContrato nominaContrato =
                    payrollContractRepository.findByIdNominaAndIdContrato(nominaNovedad.getIdNomina(), nominaNovedad.getIdContrato());
            long value = newsProcessor.processsConceptValue(nominaNovedad.getConcepto(), (int) nominaNovedad.getCantidad(), nominaContrato);
            if(value == 0) {
                nominaNovedad.setCantidad(0);
                nominaNovedad.setValor(nominaNovedad.getCantidad());
            }else {
                nominaNovedad.setValor(value);
            }
        }
    }

    @Override
    public void deleteNominaNovedad(long nominaNovedadId) {
        this.repository.delete(nominaNovedadId);
    }

    @Override
    public void loadFinalNews(Nomina nomina, NominaContrato nominaContrato) {
        LOGGER.info("Se van a cargar las novedades para el contrato: "+ nominaContrato.getContrato().getIdContrato());
        loadSalary(nomina, nominaContrato);
        loadTransportationAllowance(nomina, nominaContrato);
        loadHealthy(nomina, nominaContrato);
        loadRetirement(nomina, nominaContrato);
        loadSolidarityFound(nomina, nominaContrato);
        loadReteFuente(nomina, nominaContrato);
    }

    private void loadSalary(Nomina nomina, NominaContrato nominaContrato) {
        Concepto concepto;
        if(TypeContract.SALARIO_INTEGRAL.getType() != nominaContrato.getContrato().getTipoContrato()){
            concepto = conceptPreferences.getConceptoByClase(TypeContract.SALARIO_INTEGRAL.name());
        }else{
            concepto = conceptPreferences.getConceptoByClase(ConceptEnum.SALARY.name());
        }
        savePayrrollNew(nomina,concepto,nominaContrato);
    }

    private void loadTransportationAllowance(Nomina nomina, NominaContrato nominaContrato) {
        Concepto concepto = conceptPreferences.getConceptoByClase(ConceptEnum.TRANSPORTATION_ALLOWENCE.name());
        savePayrrollNew(nomina,concepto,nominaContrato);
    }

    private void loadHealthy(Nomina nomina, NominaContrato nominaContrato) {
        Concepto concepto = conceptPreferences.getConceptoByClase(ConceptEnum.HEALTH.name());
        savePayrrollNew(nomina,concepto,nominaContrato);
    }

    private void loadRetirement(Nomina nomina, NominaContrato nominaContrato) {
        Concepto concepto = conceptPreferences.getConceptoByClase(ConceptEnum.RETIRE.name());
        savePayrrollNew(nomina,concepto,nominaContrato);
    }

    private void loadSolidarityFound(Nomina nomina, NominaContrato nominaContrato) {
        Concepto concepto = conceptPreferences.getConceptoByClase(ConceptEnum.SOLIDARITY_FOUND.name());
        savePayrrollNew(nomina,concepto,nominaContrato);
    }

    private void loadReteFuente(Nomina nomina, NominaContrato nominaContrato) {
        Concepto concepto = conceptPreferences.getConceptoByClase(ConceptEnum.RETEFUENTE.name());
        savePayrrollNew(nomina,concepto,nominaContrato);
    }

    private void savePayrrollNew(Nomina nomina, Concepto concepto, NominaContrato nominaContrato) {
        int days = getDutyPeriod(nomina.getPeriodoNomina().getTipoNomina());
        long value = newsProcessor.processsConceptValue(concepto, days, nominaContrato);
        if(value > 0) {
            NominaNovedad nominaNovedad = new NominaNovedad();
            nominaNovedad.setIdEmpresa(nomina.getIdEmpresa());
            nominaNovedad.setConcepto(concepto);
            nominaNovedad.setCantidad(days);
            nominaNovedad.setValor(value);
            nominaNovedad.setIdNomina(nominaContrato.getIdNomina());
            nominaNovedad.setIdContrato(nominaContrato.getContrato().getIdContrato());
            this.repository.save(nominaNovedad);
        }
    }

    @Override
    public void loadAvailableNovedades(NominaContrato nominaContrato) {
        List<NominaNovedad> nominaNovedades = repository.findByIdContratoAndIdNominaIsNull(nominaContrato.getContrato().getIdContrato());
        for (NominaNovedad nominaNovedad:nominaNovedades) {
            nominaContrato.setIdNomina(nominaContrato.getIdNomina());
            repository.save(nominaNovedad);
        }
    }

    @Override
    public List<NominaNovedad> getChangesPayrollByContractAndPayroll(long idContrato, long idNomina) {
        return repository.findByIdContratoAndIdNomina(idContrato,idNomina);
    }

    @Override
    public long getTotalAccrued(Contrato contrato, long idNomina) {
        Long response = repository.sumValueByContratoAndIdNominaAndNaturaleza(contrato.getIdContrato(),idNomina,"devengo");
        return response == null?0:response;
    }

    @Override
    public long getTotalDeducted(Contrato contrato, long idNomina) {
        Long response =  repository.sumValueByContratoAndIdNominaAndNaturaleza(contrato.getIdContrato(),idNomina,"deduccion");
        return response == null?0:response;
    }

    @Override
    public long getTotalAccruedApplyEPS(long idContrato, long idNomina) {
        return repository.sumValueByIdContratoAndIdNominaAndApplyEPS(idContrato,idNomina,true);
    }

    @Override
    public long getTotalAccruedApplyRetire(long idContrato, long idNomina) {
        return repository.sumValueByIdContratoAndIdNominaAndApplyRetire(idContrato,idNomina, true);
    }

    @Override
    public void saveNominaNovedades(List<NominaNovedad> nominaNovedades) {
        repository.save(nominaNovedades);
    }

    @Override
    public List<Concepto> getConceptsPayroll(long idNomina) {
        return repository.getConceptsPayroll(idNomina);
    }

    @Override
    public List<NominaNovedad> getChangesPayrollByIdContract(long idContrato, long idNomina) {
        return repository.findByIdContratoAndIdNomina(idContrato, idNomina);
    }

    public int getDutyPeriod(String periodoPago){
        if(PeriodoPago.MENSUAL.toString().equals(periodoPago)){
            return 30;
        }else {
            return 15;
        }
    }

}
