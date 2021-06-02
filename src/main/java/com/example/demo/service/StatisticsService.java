package com.example.demo.service;

import com.example.demo.dto.STSSORD15100T01;
import com.example.demo.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticsService {
    @Autowired
    StatisticsRepository statisticsRepository;

    public List<Map<String,String>> getEquipmentChange(STSSORD15100T01 dto){
        List<Map<String,String>> postsList = statisticsRepository.getEquipmentChange(dto);
        return postsList;
    }


}
