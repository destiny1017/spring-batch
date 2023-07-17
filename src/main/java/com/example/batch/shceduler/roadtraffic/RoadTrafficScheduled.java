package com.example.batch.shceduler.roadtraffic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class RoadTrafficScheduled {

    private final Job roadTrafficPullJob;
    private final JobLauncher jobLauncher;

    @Scheduled(cron = "0 0/5 * * * *")
    public void roadTrafficPullScheduled() {
        Map<String, JobParameter> confMap = new HashMap<>();
        Date date = Calendar.getInstance().getTime();
        confMap.put("time", new JobParameter(date));
        JobParameters jobParameters = new JobParameters(confMap);

        try {
            log.info("roadTrafficPullScheduled.run");
            jobLauncher.run(roadTrafficPullJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("roadTrafficPullScheduled error time : ",
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        }
    }

}
