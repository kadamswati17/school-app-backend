package com.schoolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.schoolapp.dao.LoginRequest;
import com.schoolapp.dao.LoginResponse;
import com.schoolapp.dao.RegisterRequest;
import com.schoolapp.entity.UserEntity;
import com.schoolapp.repository.UserRepository;

//package com.crmemps.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.crmemps.dto.LoginRequest;
//import com.crmemps.dto.LoginResponse;
//import com.crmemps.dto.RegisterRequest;
//import com.crmemps.entity.UserEntity;
//import com.crmemps.repository.UserRepository;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Override
    public UserEntity getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        // 🔥 MAIN FIX
        user.setPassword(request.getPassword());

        user.setRole(request.getRole());
        user.setActive(true);   // optional but recommended

        userRepository.save(user);
    }


    // ================= LOGIN =================

    @Override
    public LoginResponse login(LoginRequest request) {

        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔥 PASSWORD CHECK
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = "dummy-token";

        return new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                token
        );
    }

}
