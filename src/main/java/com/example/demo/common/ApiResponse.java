package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private Boolean success;
    private T data;
    private ErrorResponse error;
}
