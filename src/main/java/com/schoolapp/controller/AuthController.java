package com.schoolapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.schoolapp.dao.LoginRequest;
import com.schoolapp.dao.LoginResponse;
import com.schoolapp.dao.RegisterRequest;
import com.schoolapp.service.UsersService;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = {"http://103.168.19.63:84", "http://103.168.19.63:8080"}) // More specific origins
//@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsersService userService;

    // Registration endpoint
    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> register(@RequestBody RegisterRequest request) {
        try {
            userService.register(request);

            // Return a response with status CREATED (201)
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Map.of(
                            "success", true,
                            "message", "User registered successfully"
                    ));
        } catch (Exception e) {
            // If registration fails, you can handle the error here (e.g., log it)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "success", false,
                            "message", "User registration failed"
                    ));
        }
    }

    // Sign-in endpoint
    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = userService.login(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle login error
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(null);  // You could return a custom error message here if needed
        }
    }
}

//package com.schoolapp.controller;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.schoolapp.dao.LoginRequest;
//import com.schoolapp.dao.LoginResponse;
//import com.schoolapp.dao.RegisterRequest;
//import com.schoolapp.service.UsersService;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/api/auth")
//
//public class AuthController {
//
//    @Autowired
//    private UsersService userService;
//
//    @PostMapping("/signup")
//    public ResponseEntity<Map<String, Object>> register(
//            @RequestBody RegisterRequest request) {
//
//        userService.register(request);
//
//        return ResponseEntity.ok(
//                Map.of(
//                        "success", true,
//                        "message", "User registered successfully"
//                )
//        );
//    }
//
//    @PostMapping("/signin")
//    public ResponseEntity<LoginResponse> login(
//            @RequestBody LoginRequest request) {
//
//        return ResponseEntity.ok(userService.login(request));
//    }
//}
