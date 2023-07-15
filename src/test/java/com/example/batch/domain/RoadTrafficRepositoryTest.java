package com.example.batch.domain;

import com.example.batch.domain.roadtraffic.RoadTraffic;
import com.example.batch.domain.roadtraffic.repository.RoadTrafficRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RoadTrafficRepositoryTest {

    @Autowired
    RoadTrafficRepository roadTrafficRepository;

    @Test
    void save() {
        RoadTraffic traffic = RoadTraffic.builder()
                .exDivCode("00")
                .exDivName("도공")
                .tcsType("1")
                .tcsName("TCS")
                .tmType("3")
                .tmName("5분")
                .carType("1")
                .trafficAmount("4495")
                .sumTm("1900")
                .build();

        roadTrafficRepository.save(traffic);

    }

    @Test
    void findAll() {
        List<RoadTraffic> traffics = roadTrafficRepository.findAll();
        Assertions.assertThat(traffics).hasSize(1);
    }
}