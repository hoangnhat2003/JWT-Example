package com.codingboot.Auth.domain.request;

import com.codingboot.Auth.domain.annotation.Email;
import com.codingboot.Auth.domain.annotation.Password;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Password
    @NotNull
    @NotBlank
    private String password;
}
