package com.example.batch.domain.roadtraffic.service;

import com.example.batch.domain.roadtraffic.RoadTraffic;
import com.example.batch.domain.roadtraffic.data.TrafficAllVo;
import com.example.batch.domain.roadtraffic.repository.RoadTrafficRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoadTrafficServiceImpl implements RoadTrafficService {

   private final RoadTrafficRepository roadTrafficRepository;
   private final WebClient webClient;

   public void pullRoadTraffic() {
      TrafficAllVo trafficAll = webClient.get()
              .uri("/openapi/trafficapi/trafficAll?key=test&type=json")
              .retrieve()
              .bodyToMono(TrafficAllVo.class)
              .block();
      roadTrafficRepository.saveAll(trafficAll.getTrafficAll());
   }

   public List<RoadTraffic> findAll() {
      return roadTrafficRepository.findAll();
   }

}
