package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.AppUser;
import com.example.demo.entity.Role;
import com.example.demo.exception.ResourceNotFoundException;
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
    public void register(AuthRequest request) {
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        Role role = roleRepo.findByName("CUSTOMER")
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        AppUser user = new AppUser(request.getEmail(), request.getEmail(), encoder.encode(request.getPassword()));
        user.getRoles().add(role);
        userRepo.save(user);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        AppUser user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));
        String primaryRole = user.getRoles().stream().findFirst()
                .map(Role::getName).orElse("CUSTOMER");
String token = jwtTokenProvider.generateToken(user.getUsername(), user.getId(), user.getRole());
        return new AuthResponse(token, user.getId(), user.getEmail(), primaryRole);
    }
}
