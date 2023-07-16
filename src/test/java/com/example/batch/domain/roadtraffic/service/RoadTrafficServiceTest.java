package com.example.batch.domain.roadtraffic.service;

import com.example.batch.domain.roadtraffic.RoadTraffic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RoadTrafficServiceTest {

    @Autowired
    RoadTrafficService roadTrafficService;

    @Test
    void pullRoadTrafficTest() {
        roadTrafficService.pullRoadTraffic();
        List<RoadTraffic> trafficList = roadTrafficService.findAll();
        for (RoadTraffic roadTraffic : trafficList) {
            System.out.println("roadTraffic.amount = " + roadTraffic.getTrafficAmout());
        }
    }
}