package com.smartservice.nomina.process.batch.scheduler;

import com.smartservice.nomina.process.batch.config.BatchConfigurationPayroll;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class BatchSchedulerPayroll {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private BatchConfigurationPayroll batchConfiguration;

    private Long jobIdentifier ;

    private final String JOB_ID_PAYROLL = "jobId";


    @Scheduled(fixedRateString = "${job.nomina.polling-frequency}")
    public void runNominasJob() throws Exception{
        jobIdentifier = Calendar.getInstance().getTimeInMillis();
        Job job = batchConfiguration.createNominaJob();
        JobParameters jobParameters = new JobParametersBuilder().addString(JOB_ID_PAYROLL, jobIdentifier.toString())
                .toJobParameters();
        jobLauncher.run(job, jobParameters);
    }
}
