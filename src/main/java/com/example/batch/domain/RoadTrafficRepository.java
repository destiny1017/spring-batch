package com.example.batch.domain;

import java.util.List;

public interface RoadTrafficRepository {
    void save(RoadTraffic roadTraffic);
    List<RoadTraffic> findAll();
}
