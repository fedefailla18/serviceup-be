package com.serviceup.serviceup.model;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String email;
    private String password;
}
