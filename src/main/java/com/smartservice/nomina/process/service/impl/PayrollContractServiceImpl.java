package com.smartservice.nomina.process.service.impl;

import com.smartservice.nomina.process.model.*;
import com.smartservice.nomina.process.repository.PayrollContractRepository;
import com.smartservice.nomina.process.service.*;
import com.smartservice.nomina.process.util.ConceptEnum;
import com.smartservice.nomina.process.util.EstadoContrato;
import com.smartservice.nomina.process.util.PeriodoPago;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PayrollContractServiceImpl implements PayrollContractService {


    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollContractServiceImpl.class);

    @Autowired
    private PayrollContractRepository payrollContractRepository;

    @Autowired
    private ContractService contractService;

    @Autowired
    private PayrollNewsService payrollNewsService;

    @Autowired
    private NewsScheduledService newsScheduledService;

    @Autowired
    private DiscountService descuentoService;

    @Override
    public List<NominaContrato> getAllNominaContrato() {
        return this.payrollContractRepository.findAll();
    }

    @Override
    public List<ResponseNominaContrato> getNominaContratosByIdNomina(long idNomina) {
        LOGGER.info("Se van a consultar los contratos de la nomina: "+idNomina);
        List<ResponseNominaContrato> responseNominaContratos = new ArrayList<>();
        List<NominaContrato> nominaContratos = this.payrollContractRepository.findByIdNomina(idNomina);
        ResponseNominaContrato responseNominaContrato ;
        for(NominaContrato nominaContrato:nominaContratos){
            responseNominaContrato = new ResponseNominaContrato();
            fillContractInformation(responseNominaContrato, nominaContrato);
            fillChangesPayroll(responseNominaContrato,nominaContrato);
            fillTotals(responseNominaContrato, nominaContrato);
            responseNominaContratos.add(responseNominaContrato);
        }
        return responseNominaContratos;
    }

    @Override
    public long findIbcLastMonth(long idContrato) {
        return 0;
    }

    private void fillTotals(ResponseNominaContrato responseNominaContrato, NominaContrato nominaContrato ) {
        long totalAccrued = payrollNewsService.getTotalAccrued(nominaContrato.getContrato(), nominaContrato.getIdNomina());
        long totalDeducted = payrollNewsService.getTotalDeducted(nominaContrato.getContrato(), nominaContrato.getIdNomina());
        long net = totalAccrued - totalDeducted;
        responseNominaContrato.setTotalDeducted(totalDeducted);
        responseNominaContrato.setTotalAccrued(totalAccrued);
        responseNominaContrato.setNetPay(net);
    }

    private void fillChangesPayroll(ResponseNominaContrato responseNominaContrato, NominaContrato nominaContrato) {
        Map<String,NominaNovedad> stringNominaNovedadMap = new HashMap<>();
        List<NominaNovedad> nominaNovedades =
                payrollNewsService.getChangesPayrollByContractAndPayroll(nominaContrato.getContrato().getIdContrato(), nominaContrato.getIdNomina());
        nominaNovedades.forEach(
                nominaNovedad -> {
                    stringNominaNovedadMap.put(""+nominaNovedad.getConcepto().getIdConcepto(),nominaNovedad);
                }
        );
        responseNominaContrato.setChangesPayroll(stringNominaNovedadMap);
    }

    private ResponseChangesPayroll getChangePayrollType(List<NominaNovedad> changesPayroll, ConceptEnum conceptEnum) {
        final ResponseChangesPayroll[] responseChangesPayroll = new ResponseChangesPayroll[1];
        changesPayroll.forEach(response -> {
            //if(conceptEnum.equals(response.getTypeConceptEnum())){
            //responseChangesPayroll[0] = response;
            //}
        });
        return responseChangesPayroll[0];
    }

    private void fillContractInformation(ResponseNominaContrato responseNominaContrato, NominaContrato nominaContrato) {
        Contrato contract = nominaContrato.getContrato();
        Empleado employee = contract.getEmpleado();
        responseNominaContrato.setIdContract(contract.getIdContrato());
        responseNominaContrato.setDocument(employee.getNumeroDocumento());
        responseNominaContrato.setEmployeeName(getEmployeeName(employee));
        responseNominaContrato.setSalary(contract.getSueldo());
        responseNominaContrato.setStartDate(contract.getFechaInicio());
        responseNominaContrato.setRetirementDate(contract.getFechaFin());
        responseNominaContrato.setPay(determinePay(contract.getSueldo(), contract.getPeriodoPago()));
        responseNominaContrato.setWorkedDays(determineWorkedDays(contract.getPeriodoPago()));
    }

    private String getEmployeeName(Empleado employee) {
        return String.format("%s",employee.getPrimerNombre()+" "+employee.getSegundoNombre()+" "+employee.getPrimerApellido()+" "+employee.getSegundoApellido()).toUpperCase();
    }

    private int determineWorkedDays(String periodoPago) {
        if(PeriodoPago.QUINCENAL.toString().equals(periodoPago)){
            return 15;
        }else{
            return 30;
        }
    }

    private long determinePay(long sueldo, String periodoPago) {
        if(PeriodoPago.QUINCENAL.toString().equals(periodoPago)){
            return sueldo/2;
        }else{
            return sueldo;
        }
    }

    @Override
    public NominaContrato saveNominaContrato(NominaContrato nominaContrato) {
        LOGGER.info("Se va a almacenar el contrato: "+ nominaContrato.getContrato().getIdContrato() +
                " para la Nomina: "+ nominaContrato.getIdNomina());
        return this.payrollContractRepository.save(nominaContrato);
    }

    @Override
    public void deleteNominaContrato(long nominaContratoId) {
        this.payrollContractRepository.delete(nominaContratoId);
    }

    @Override
    public List<NominaContrato> createNominaContratos(Nomina nomina){
        LOGGER.info("Se van a crear los contratos de la nomina");
        List<Contrato> contratos =
                this.contractService.getContratosByIdEmpresaAndEstatusAndPeriodoPago(nomina.getIdEmpresa(),
                        EstadoContrato.ACTIVO.toString(),
                        nomina.getPeriodoNomina().getTipoNomina());
        LOGGER.info("Total contratos encontrados: "+ contratos.size());
        List<NominaContrato> nominaContratos = new ArrayList<>();
        NominaContrato nominaContrato ;
        for (Contrato contrato:contratos ) {
            nominaContrato = new NominaContrato();
            nominaContrato.setContrato(contrato);
            nominaContrato.setIdNomina(nomina.getIdNomina());
            nominaContrato = this.payrollContractRepository.save(nominaContrato);
            nominaContratos.add(nominaContrato);

        }
        this.payrollContractRepository.save(nominaContratos);
        return nominaContratos;
    }

}
