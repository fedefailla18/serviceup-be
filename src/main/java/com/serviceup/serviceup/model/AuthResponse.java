package com.serviceup.serviceup.model;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class AuthResponse {
    private final String jwt;

    public String getJwt() {
        return jwt;
    }
}
