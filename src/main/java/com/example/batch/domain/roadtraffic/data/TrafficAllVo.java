package com.example.batch.domain.roadtraffic.data;

import com.example.batch.domain.roadtraffic.RoadTraffic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrafficAllVo {
    private String code;
    private String message;
    private Long count;
    private List<RoadTraffic> trafficAll = new ArrayList<>();
}
