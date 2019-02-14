package com.smartservice.nomina.process.batch.config;

import com.smartservice.nomina.process.batch.listener.PayrollJobExecutionListener;
import com.smartservice.nomina.process.batch.processor.PayrollItemProcessor;
import com.smartservice.nomina.process.batch.reader.PayrollItemReader;
import com.smartservice.nomina.process.batch.writer.PayrollItemWriter;
import com.smartservice.nomina.process.model.Nomina;
import com.smartservice.nomina.process.repository.PayrollRepository;
import com.smartservice.nomina.process.util.EstadoNomina;
import com.smartservice.nomina.process.common.NominaServiceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
public class BatchConfigurationPayroll extends SimpleBatchConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchConfigurationPayroll.class);

    @Autowired
    private JobBuilderFactory jobBuilderFactoryPayroll;

    @Autowired
    private StepBuilderFactory stepBuilderFactoryPayroll;

    @Autowired
    private PayrollRepository payrollRepository;
    @Autowired
    private PayrollItemProcessor payrollItemProcessor;

    @Autowired
    private PayrollItemWriter payrollItemWriter;


    private Step createNominaStep() {
        return stepBuilderFactoryPayroll.get(NominaServiceConstants.STEP_NAME_NOMINA)
                .<Nomina, Nomina> chunk(5)
                .reader(getNominaReader())
                .processor(getNominaProcessor())
                .writer(getNominaWriter())
                .build();
    }

    public Job createNominaJob() throws Exception {
        return jobBuilderFactoryPayroll.get(NominaServiceConstants.JOB_NAME_NOMINA)
                .incrementer(new RunIdIncrementer())
                .listener(getNominaJobListener())
                .start(createNominaStep())
                .build();
    }

    public PayrollItemReader getNominaReader() {
        LOGGER.debug("Inicio consulta del Reader Job Nomina");
        PayrollItemReader repositoryItemReader= new PayrollItemReader();
        repositoryItemReader.setRepository(payrollRepository);

        repositoryItemReader.setMethodName(NominaServiceConstants.METHOD_NAME_NOMINA);
        repositoryItemReader.setArguments(getNominaQueryArgumentsList());

        return repositoryItemReader;
    }

    private List getNominaQueryArgumentsList(){
        List<Object> queryArgumentsList = new ArrayList<>();
        queryArgumentsList.add(EstadoNomina.PENDIENTE.toString());
        return queryArgumentsList;
    }

    public PayrollItemProcessor getNominaProcessor() {
        return this.payrollItemProcessor;
    }

    public PayrollItemWriter getNominaWriter() {
        return this.payrollItemWriter;
    }

    public JobExecutionListener getNominaJobListener() {
        return new PayrollJobExecutionListener();
    }


}
