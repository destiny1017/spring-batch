package com.example.batch.domain.roadtraffic.repository;

import com.example.batch.domain.roadtraffic.RoadTraffic;

import java.util.List;

public interface RoadTrafficRepository {
    void save(RoadTraffic roadTraffic);
    List<RoadTraffic> findAll();
}
