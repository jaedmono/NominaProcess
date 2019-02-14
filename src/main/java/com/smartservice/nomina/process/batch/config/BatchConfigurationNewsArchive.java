package com.smartservice.nomina.process.batch.config;

import com.smartservice.nomina.process.batch.listener.NewsArchiveJobExecutionListener;
import com.smartservice.nomina.process.batch.processor.NewsArchiveItemProcessor;
import com.smartservice.nomina.process.batch.reader.NewsArchiveItemReader;
import com.smartservice.nomina.process.batch.writer.NewsArchiveItemWriter;
import com.smartservice.nomina.process.model.ArchivoNovedad;
import com.smartservice.nomina.process.model.ArchivoNovedadContent;
import com.smartservice.nomina.process.repository.NewsArchiveRepository;
import com.smartservice.nomina.process.util.EstadoArchivosNovedad;
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
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableTransactionManagement
@Configuration
@EnableBatchProcessing
@EnableAutoConfiguration
public class BatchConfigurationNewsArchive extends SimpleBatchConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchConfigurationNewsArchive.class);

    @Autowired
    private JobBuilderFactory jobBuilderFactoryNewsArchive;

    @Autowired
    private StepBuilderFactory stepBuilderFactoryNewsArchive;

    @Autowired
    private NewsArchiveRepository newsArchiveRepository;

    @Autowired
    private NewsArchiveItemProcessor newsArchiveItemProcessor;

    @Autowired
    private NewsArchiveItemWriter newsArchiveItemWriter;



    private Step createArchivoNovedadesStep() {
        return stepBuilderFactoryNewsArchive.get(NominaServiceConstants.STEP_NAME_ARCHIVO)
                .<ArchivoNovedad, ArchivoNovedadContent> chunk(5)
                .reader(getReaderArchivoNovedades())
                .processor(getProcessorArchivoNovedades())
                .writer(getWriterArchivoNovedades())
                .build();
    }

    public Job createArchivoNovedadesJob() throws Exception {
        return jobBuilderFactoryNewsArchive.get(NominaServiceConstants.JOB_NAME_ARCHIVO)
                .incrementer(new RunIdIncrementer())
                .listener(getJobListenerArchivoNovedades())
                .start(createArchivoNovedadesStep())
                .build();
    }

    public NewsArchiveItemReader getReaderArchivoNovedades() {
        LOGGER.debug("Inicio consulta del Reader");
        NewsArchiveItemReader repositoryItemReader= new NewsArchiveItemReader();
        repositoryItemReader.setRepository(newsArchiveRepository);

        repositoryItemReader.setMethodName(NominaServiceConstants.METHOD_NAME);
        repositoryItemReader.setArguments(getQueryArgumentsList());

        Map<String, Sort.Direction> sortMap = new HashMap<>();
        sortMap.put(NominaServiceConstants.SORTING_COLUMN ,Sort.Direction.ASC);
        repositoryItemReader.setSort(sortMap);
        return repositoryItemReader;
    }

    private List getQueryArgumentsList(){
        List<Object> queryArgumentsList = new ArrayList<>();
        queryArgumentsList.add(EstadoArchivosNovedad.CARGADO.toString());
        return queryArgumentsList;
    }

    public NewsArchiveItemProcessor getProcessorArchivoNovedades() {
        return this.newsArchiveItemProcessor;
    }

    public NewsArchiveItemWriter getWriterArchivoNovedades() {
        return this.newsArchiveItemWriter;
    }

    public JobExecutionListener getJobListenerArchivoNovedades() {
        return new NewsArchiveJobExecutionListener();
    }

}
