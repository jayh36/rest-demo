package com.example.demo.exception;

import com.example.demo.common.ApiResponse;
import com.example.demo.common.ErrorCode;
import com.example.demo.common.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * handle specific exceptions
     */
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<ErrorResponse> handleDataNotFoundException(DataNotFoundException ex){
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.RESOURCE_NOT_FOUND);
        errorResponse.setDetail(ex.getMessage());
        return new ApiResponse(false, null, errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request){
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_PARAMETER);
        errorResponse.setDetail(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return new ApiResponse(false, null, errorResponse);
    }

    @ExceptionHandler(BindException.class)
    protected ApiResponse<ErrorResponse> handleBindException(BindException ex, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INVALID_PARAMETER);
        errorResponse.setDetail(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return new ApiResponse(false, null, errorResponse);
    }

    /**
     * handle global exceptions
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<ErrorResponse> handleGlobalExceptions(Exception ex, WebRequest request){
        log.error("handleGlobalExceptions", ex);
        ErrorResponse errorResponse = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        errorResponse.setDetail(ex.getMessage());
        return new ApiResponse(false, null, errorResponse);
    }
    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalExceptions(Exception ex, WebRequest request){
        log.error("handleGlobalExceptions", ex);
        ErrorResponse errorResponse = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

}

