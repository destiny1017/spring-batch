package com.example.batch.domain.roadtraffic.service;

import com.example.batch.domain.roadtraffic.RoadTraffic;

import java.util.List;

public interface RoadTrafficService {
    void pullRoadTraffic();
    List<RoadTraffic> findAll();
}
