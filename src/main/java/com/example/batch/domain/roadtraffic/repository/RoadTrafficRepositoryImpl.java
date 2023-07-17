package com.example.batch.domain.roadtraffic.repository;

import com.example.batch.domain.roadtraffic.RoadTraffic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class RoadTrafficRepositoryImpl implements RoadTrafficRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DateTimeFormatter dateTimeFormatter;

    @Override
    public void save(RoadTraffic roadTraffic) {
        String sql = "insert into service.road_traffic(ex_div_code, ex_div_name, tcs_type, tcs_name," +
                "tm_type, tm_name, car_type, traffic_amount, sum_tm, created_date_time) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
            roadTraffic.getExDivCode(),
            roadTraffic.getExDivName(),
            roadTraffic.getTcsType(),
            roadTraffic.getTcsName(),
            roadTraffic.getTmType(),
            roadTraffic.getTmName(),
            roadTraffic.getCarType(),
            roadTraffic.getTrafficAmout(),
            roadTraffic.getSumTm(),
            LocalDateTime.now().format(dateTimeFormatter));
    }

    @Override
    public void saveAll(List<RoadTraffic> trafficAll) {
        String sql = "insert into service.road_traffic(ex_div_code, ex_div_name, tcs_type, tcs_name," +
                "tm_type, tm_name, car_type, traffic_amount, sum_tm, created_date_time) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, trafficAll.get(i).getExDivCode());
                ps.setString(2, trafficAll.get(i).getExDivName());
                ps.setString(3, trafficAll.get(i).getTcsType());
                ps.setString(4, trafficAll.get(i).getTcsName());
                ps.setString(5, trafficAll.get(i).getTmType());
                ps.setString(6, trafficAll.get(i).getTmName());
                ps.setString(7, trafficAll.get(i).getCarType());
                ps.setString(8, trafficAll.get(i).getTrafficAmout());
                ps.setString(9, trafficAll.get(i).getSumTm());
                ps.setString(10, LocalDateTime.now().format(dateTimeFormatter));
            }

            @Override
            public int getBatchSize() {
                return trafficAll.size();
            }
        });
    }

    @Override
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
                    .trafficAmout(rs.getString("traffic_amount"))
                    .sumTm(rs.getString("sum_tm"))
                    .createdDateTime(LocalDateTime.parse(rs.getString("created_date_time"), dateTimeFormatter))
                    .build();
        });
    }
}
