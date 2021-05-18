package com.example.demo.exception;

import com.example.demo.model.ApiErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiErrorDetail> handleUserNotFoundException(DataNotFoundException dnfe){
        ApiErrorDetail errorDetail = new ApiErrorDetail();
        errorDetail.setTimeStamp(new Date());
        errorDetail.setCode(1002);
        errorDetail.setMessage(dnfe.getMessage());
        return new ResponseEntity(errorDetail, HttpStatus.NOT_FOUND);
    }
/*    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }*/

}

