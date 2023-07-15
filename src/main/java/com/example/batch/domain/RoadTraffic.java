package com.example.batch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RoadTraffic {
    private String exDivCode;
    private String exDivName;
    private String tcsType;
    private String tcsName;
    private String tmType;
    private String tmName;
    private String carType;
    private String trafficAmount;
    private String sumTm;
}
