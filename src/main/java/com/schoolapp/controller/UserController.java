package com.schoolapp.controller;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.schoolapp.entity.UserEntity;
import com.schoolapp.repository.UserRepository;
import com.schoolapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;
//    private final PasswordEncoder encoder;
    private final UserService service;

//    public UserController(UserRepository userRepository,
//                          PasswordEncoder encoder,
//                          UserService service) {
//        this.userRepository = userRepository;
//        this.encoder = encoder;
//        this.service = service;
//    }
    
    public UserController(UserRepository userRepository,
            UserService service) {
this.userRepository = userRepository;
this.service = service;
}

    // -----------------------------------------------------------------------------------
    // EXISTING ADMIN USER MANAGEMENT API (unchanged logic)
    // -----------------------------------------------------------------------------------

    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {

    	user.setPassword(user.getPassword());


        return service.createUser(user);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id,
                                 @RequestBody UserEntity updatedUser) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setMobile(updatedUser.getMobile());
        user.setRole(updatedUser.getRole());

        if (updatedUser.getProfileImage() != null &&
                !updatedUser.getProfileImage().isEmpty()) {
            user.setProfileImage(updatedUser.getProfileImage());
        }

        if (updatedUser.getPassword() != null &&
                !updatedUser.getPassword().isEmpty()) {
        	user.setPassword(updatedUser.getPassword());

        }

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    // Activate
    @PutMapping("/{id}/activate")
    public UserEntity activateUser(@PathVariable Long id) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setActive(true);
        return userRepository.save(user);
    }

    // Deactivate
    @PutMapping("/{id}/deactivate")
    public UserEntity deactivateUser(@PathVariable Long id) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setActive(false);
        return userRepository.save(user);
    }

    // -----------------------------------------------------------------------------------
    // RETURN USERS LIST EXCEPT GIVEN USER
    // -----------------------------------------------------------------------------------
    @GetMapping
    public List<UserEntity> list(
            @RequestParam(value = "excludeId", required = false) Long excludeId) {

        return service.listAllExcept(excludeId);
    }

    // -----------------------------------------------------------------------------------
    @PutMapping("/{id}/profile")
    public UserEntity updateOwnProfile(@PathVariable Long id,
                                       @RequestBody UserEntity updatedUser) {

        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setMobile(updatedUser.getMobile());

        if (updatedUser.getPassword() != null &&
                !updatedUser.getPassword().isEmpty()) {

            // 🔥 DIRECT SAVE (NO ENCODER)
            user.setPassword(updatedUser.getPassword());
        }

        if (updatedUser.getProfileImage() != null &&
                !updatedUser.getProfileImage().isEmpty()) {

            user.setProfileImage(updatedUser.getProfileImage());
        }

        return userRepository.save(user);
    }


    @GetMapping("/{id}/info")
    public UserEntity getUserInfo(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping("/parties")
    public List<UserEntity> getPartyUsers() {
        return userRepository.findByRole("ROLE_PARTY_NAME");
    }
}
