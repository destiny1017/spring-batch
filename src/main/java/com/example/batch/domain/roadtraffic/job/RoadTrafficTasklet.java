package com.example.batch.domain.roadtraffic.job;

import com.example.batch.domain.roadtraffic.service.RoadTrafficService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@StepScope
public class RoadTrafficTasklet implements Tasklet {

    private final RoadTrafficService roadTrafficService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        roadTrafficService.pullRoadTraffic();
        return RepeatStatus.FINISHED;
    }
}
