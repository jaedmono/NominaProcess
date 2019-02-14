package com.smartservice.nomina.process.factory;

import com.smartservice.nomina.process.factory.concept.*;
import com.smartservice.nomina.process.model.Concepto;
import com.smartservice.nomina.process.model.NominaContrato;
import com.smartservice.nomina.process.repository.PayrollContractRepository;
import com.smartservice.nomina.process.repository.PayrollNewRepository;
import com.smartservice.nomina.process.util.ConceptEnum;
import com.smartservice.nomina.process.util.UserPreference;
import com.smartservice.nomina.process.common.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConceptFactory {

    @Autowired
    private PayrollNewRepository payrollNewRepository;

    @Autowired
    private PayrollContractRepository payrollContractRepository;

    @Autowired
    private UserPreferences userPreferences ;


    public BasicConcept getExecutorConcept(Concepto concepto, int time, NominaContrato nominaContrato){
        BasicConcept basicConcept = null;
        long ibcLastMonth = 0;
        long totalSalary= 0;
        long transportAllowence= 0;
        long minimumSalary = 0;
        ConceptEnum conceptEnum = ConceptEnum.valueOf(concepto.getClase());
        switch (conceptEnum){
            case HEALTH:
                totalSalary =
                        payrollNewRepository.sumValueByIdContratoAndIdNominaAndApplyEPS(nominaContrato.getContrato().getIdContrato(),nominaContrato.getIdNomina(),true);
                basicConcept = new HealthyConcept(concepto, totalSalary);
                break;
            case RETIRE:
                totalSalary =
                        payrollNewRepository.sumValueByIdContratoAndIdNominaAndApplyRetire(nominaContrato.getContrato().getIdContrato(),nominaContrato.getIdNomina(),true);
                basicConcept = new RetirementConcept(concepto, totalSalary);
                break;
            case RETEFUENTE:
                totalSalary =
                        payrollNewRepository.sumValueByIdContratoAndIdNominaAndApplyRetire(nominaContrato.getContrato().getIdContrato(),nominaContrato.getIdNomina(),true);
                minimumSalary = Long.valueOf(userPreferences.getUserPreference(UserPreference.MINIMUM_SALARY));
                basicConcept = new Retefuente(concepto, totalSalary, minimumSalary);
                break;
            case TRANSPORTATION_ALLOWENCE:
                transportAllowence = Long.valueOf(userPreferences.getUserPreference(UserPreference.ALLOWENCE_TRANSPORTATION));
                minimumSalary = Long.valueOf(userPreferences.getUserPreference(UserPreference.MINIMUM_SALARY));
                basicConcept = new TransportationAllowance(  time , nominaContrato.getContrato().getSueldo(), transportAllowence, minimumSalary);
                break;
            case SALARY:
                basicConcept = new SalaryConcept(nominaContrato.getContrato().getSueldo(), time);
                break;
            case DISCOUNT_TRANSPORTATION_ALLOWENCE:
                transportAllowence = Long.valueOf(userPreferences.getUserPreference(UserPreference.ALLOWENCE_TRANSPORTATION));
                basicConcept = new DiscountTransportationAllowance( time, transportAllowence);
                break;
            case DAYS_BASIC_CONCEPT:
                basicConcept = new DaysBasicConcept(nominaContrato.getContrato().getSueldo(), time);
                break;
            case EXTRA_HOUR:
                basicConcept = new ExtraHour(concepto, nominaContrato, time);
                break;
            case INABILITY_COMPANY:
                ibcLastMonth = getIbcLastMonth(nominaContrato);
                basicConcept = new InabilityCompany(ibcLastMonth,time);
                break;
            case INABILITY_EPS:
                basicConcept = new InabilityEPS(nominaContrato.getContrato().getSueldo(),time);
                break;
            case SOLIDARITY_FOUND:
                totalSalary =
                        payrollNewRepository.sumValueByContratoAndIdNominaAndNaturaleza(nominaContrato.getContrato().getIdContrato(),nominaContrato.getIdNomina(),"devengo");
                minimumSalary = Long.valueOf(userPreferences.getUserPreference(UserPreference.MINIMUM_SALARY));
                basicConcept = new SolidarityFound(totalSalary,concepto,minimumSalary);
                break;
            case INABILITY_ACCIDENT_JOB_COMPANY:
                basicConcept = new JobAccidentAdmin(nominaContrato.getContrato().getSueldo(),time);
                break;
            case INABILITY_ACCIDENT_JOB_ADMIN:
                ibcLastMonth = getIbcLastMonth(nominaContrato);
                basicConcept = new JobAccidentCompany(ibcLastMonth,time);
                break;
            case LICENSE:
                ibcLastMonth = getIbcLastMonth(nominaContrato);
                basicConcept = new License(ibcLastMonth,time);
                break;
            case VACATIONS:
                long avgSalary = getIbcLastMonth(nominaContrato);;
                basicConcept = new Vacations(avgSalary,time);
                break;
        }
        return basicConcept;
    }

    private long getIbcLastMonth(NominaContrato nominaContrato) {
        long salary =  payrollContractRepository.findByIdContratoLastAccrued(nominaContrato.getContrato().getIdContrato());
        salary = salary == 0?nominaContrato.getContrato().getSueldo(): salary;
        return salary;
    }
}
