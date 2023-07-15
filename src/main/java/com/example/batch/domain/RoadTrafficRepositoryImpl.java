package com.example.batch.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class RoadTrafficRepositoryImpl implements RoadTrafficRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(RoadTraffic roadTraffic) {
        String sql = "insert into service.road_traffic(ex_div_code, ex_div_name, tcs_type, tcs_name," +
                "tm_type, tm_name, car_type, traffic_amount, sum_tm) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
            roadTraffic.getExDivCode(),
            roadTraffic.getExDivName(),
            roadTraffic.getTcsType(),
            roadTraffic.getTcsName(),
            roadTraffic.getTmType(),
            roadTraffic.getTmName(),
            roadTraffic.getCarType(),
            roadTraffic.getTrafficAmount(),
            roadTraffic.getSumTm());
    }

    public List<RoadTraffic> findAll() {
        String sql = "select * from service.road_traffic";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            return RoadTraffic.builder()
                    .exDivCode(rs.getString("ex_div_code"))
                    .exDivName(rs.getString("ex_div_name"))
                    .tcsType(rs.getString("tcs_type"))
                    .tcsName(rs.getString("tcs_name"))
                    .tmType(rs.getString("tm_type"))
                    .tmName(rs.getString("tm_name"))
                    .carType(rs.getString("car_type"))
                    .trafficAmount(rs.getString("traffic_amount"))
                    .sumTm(rs.getString("sum_tm"))
                    .build();
        });
    }
}
