package com.example.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
//@RequiredArgsConstructor
public class ExamScheduleService {

//    private final JobLauncher jobLauncher;
//    private final Job job;
//
//    @Scheduled(cron = "0/30 * * * * ?")
//    public void examSchedule() {
//        Map<String, JobParameter> confMap = new HashMap<>();
//        Date date = Calendar.getInstance().getTime();
//        confMap.put("time", new JobParameter(date));
//        JobParameters jobParameters = new JobParameters(confMap);
//
//        try {
//            jobLauncher.run(job, jobParameters);
//        } catch (Exception e) {
//            log.error("job schedule error time : ",
//                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
//        }
//    }
}
