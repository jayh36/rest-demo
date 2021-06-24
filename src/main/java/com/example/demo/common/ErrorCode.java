package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode implements EnumModel {

    // COMMON
    INTERNAL_SERVER_ERROR(500, "C001", "Resource not found"),
    INVALID_PARAMETER(400, "C002", "Invalid parameter"),
    RESOURCE_NOT_FOUND(204, "C003", "Resource not found");

    private int status; //HttpStatus
    private String code; //자체 정의한 ErrorCode
    private String message; //Error메시지
    private String detail;
    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.message = message;

        this.code = code;
    }

    @Override
    public String getKey() {
        return this.code;
    }

    @Override
    public String getValue() {
        return this.message;
    }
}