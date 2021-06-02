package com.example.demo.repository;

import com.example.demo.dto.STSSORD15100T01;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface StatisticsRepository {
        List<Map<String,String>> getEquipmentChange(STSSORD15100T01 dto);
}
