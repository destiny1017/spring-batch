package com.example.batch.domain.roadtraffic.service;

import com.example.batch.domain.roadtraffic.RoadTraffic;
import com.example.batch.domain.roadtraffic.data.TrafficAllVo;
import com.example.batch.domain.roadtraffic.repository.RoadTrafficRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoadTrafficServiceImpl implements RoadTrafficService {

   private final RoadTrafficRepository roadTrafficRepository;
   private final WebClient webClient;

   public void pullRoadTraffic() {
      log.info("RoadTrafficServiceImpl.pullRoadTraffic");
      TrafficAllVo trafficAll = webClient.get()
              .uri("/openapi/trafficapi/trafficAll?key=test&type=json&exDivCode=00&tcsType=1&tmType=1")
              .retrieve()
              .bodyToMono(TrafficAllVo.class)
              .block();
      roadTrafficRepository.saveAll(trafficAll.getTrafficAll());
   }

   public List<RoadTraffic> findAll() {
      return roadTrafficRepository.findAll();
   }

}
