package com.example.batch.domain.roadtraffic.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RoadTrafficJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final RoadTrafficTasklet roadTrafficTasklet;

    @Bean
    public Job roadTrafficPullJob() {
        return jobBuilderFactory.get("roadTrafficJob")
                .start(roadTrafficPullStep())
                .build();
    }

    @Bean
    public Step roadTrafficPullStep() {
        return stepBuilderFactory.get("roadTrafficPullStep")
                .tasklet(roadTrafficTasklet)
                .build();
    }
}
