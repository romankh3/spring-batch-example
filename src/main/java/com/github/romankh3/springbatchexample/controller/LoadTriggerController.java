package com.github.romankh3.springbatchexample.controller;

import java.util.logging.Logger;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoadTriggerController {

    private final static Logger LOGGER = Logger.getLogger(LoadTriggerController.class.getName());

    @Autowired
    private Job job;

    @Autowired
    private JobLauncher launcher;

    @GetMapping
    public String home() {
        return "to trigger load data, please move to /load";
    }

    @GetMapping("/load")
    public BatchStatus load() throws Exception {
        JobParameters parameters = new JobParameters();
        JobExecution jobExecution = launcher.run(job, parameters);

        LOGGER.info("JobExecution: " + jobExecution.getStatus());

        while(jobExecution.isRunning()) {
            System.out.print(".");
        }

        return jobExecution.getStatus();
    }
}
