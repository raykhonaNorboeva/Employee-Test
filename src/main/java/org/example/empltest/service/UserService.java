package org.example.empltest.service;

import lombok.RequiredArgsConstructor;
import org.example.empltest.domain.dto.AuthRequest;
import org.example.empltest.domain.dto.AuthResponse;
import org.example.empltest.domain.entity.UserEntity;
import org.example.empltest.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(AuthRequest request) {
        UserEntity user = userRepository.findByLogin(request.getLogin())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        String token = jwtService.generateToken(user.getLogin());
        return new AuthResponse(token);
    }


/*    public AuthResponse register(AuthRequest request) {
        if (userRepository.findByLogin(request.getLogin()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        UserEntity user = new UserEntity();
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        String token = jwtService.generateToken(user.getLogin());
        return new AuthResponse(token);
    }*/
}