package com.serviceup.serviceup.service;

import com.serviceup.serviceup.model.Role;
import com.serviceup.serviceup.model.User;
import com.serviceup.serviceup.repository.RoleRepository;
import com.serviceup.serviceup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService  {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(String email, String password, String userType) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email is already in use");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        Role role = roleRepository.findByName(userType.contains("SERVICE_PROVIDER") ? "ROLE_SERVICE_PROVIDER" : "ROLE_CUSTOMER")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRoles(Set.of(role));

        return userRepository.save(user);
    }
}
