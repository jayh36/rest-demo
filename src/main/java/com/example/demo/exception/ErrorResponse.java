package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    private Date timeStamp;
    private String message;
    private String path;
    //{"timestamp":"2021-06-02T02:46:29.672+00:00"
    // ,"status":404
    // ,"error":"Not Found"
    // ,"message":""
    // ,"path":"/statistics/equipment/change3"}
}

