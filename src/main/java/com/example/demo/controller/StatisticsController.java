package com.example.demo.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.exception.DataNotFoundException;
import com.example.demo.dto.STSSORD15100T01;
import com.example.demo.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/statistics")
public class StatisticsController {
    @Autowired
    StatisticsService statisticsService;

    // 단말기변경통계 : STSSORD15100T01
    @GetMapping("equipment/change")
    public ApiResponse equipmentChange(@Valid STSSORD15100T01 dto) {
        //log.info("******** input : " + dto.toString() );

        List<Map<String,String>> result = statisticsService.getEquipmentChange(dto);
        if( result.size() == 0 ) throw new DataNotFoundException("Data not found");
        return new ApiResponse(true, result, null);
        //return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("equipment/change2")
    public ApiResponse equipmentChange() {
        //log.info("******** input : " + dto.toString() );
        return new ApiResponse(true, "result", null);
    }

}
