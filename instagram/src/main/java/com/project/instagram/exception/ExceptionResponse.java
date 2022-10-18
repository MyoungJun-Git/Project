package com.project.instagram.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ExceptionResponse {

    private String message;
    private String code;
    private int status;
    private List<FieldError> errors = new ArrayList<>();

    @Builder
    public ExceptionResponse(String message, String code, int status, List<FieldError> errors) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.errors = initErrors(errors);
    }

    private List<FieldError> initErrors(List<FieldError> errors) {
        return (errors == null) ? new ArrayList<>() : errors;
    }

    @Getter
    public static class FieldError {
        private String field;
        private String value;
        private String detail;

        @Builder
        public FieldError(String i_field, String i_value, String i_detail) {
            this.field = i_field;
            this.value = i_value;
            this.detail = i_detail;
        }
    }
}