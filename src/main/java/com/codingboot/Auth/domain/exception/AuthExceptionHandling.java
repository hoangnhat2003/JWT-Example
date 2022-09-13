package com.codingboot.Auth.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthExceptionHandling extends RuntimeException {
    private int code;
    private String message;
    private Object data;
}
