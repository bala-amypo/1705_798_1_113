package com.example.demo.service.impl;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwtProvider;

    public AuthServiceImpl(AppUserRepository userRepo, RoleRepository roleRepo,
                           PasswordEncoder encoder, JwtTokenProvider jwtProvider) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void register(RegisterRequest request) {
        if (userRepo.existsByEmail(request.getUsername())) {
            throw new IllegalArgumentException("User already exists");
        }
        Role role = roleRepo.findByName("CUSTOMER").orElseThrow();
        AppUser user = new AppUser(request.getUsername(), request.getUsername(), encoder.encode(request.getPassword()));
        user.getRoles().add(role);
        userRepo.save(user);
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        AppUser user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
        String token = jwtProvider.generateToken(user.getEmail(), user.getId(), user.getRoles().iterator().next().getName());
        return new AuthResponse(token, user.getId(), user.getFullName(), user.getEmail());
    }
}
