package com.schoolapp.service;

import com.schoolapp.dao.LoginRequest;
import com.schoolapp.dao.LoginResponse;
import com.schoolapp.dao.RegisterRequest;
import com.schoolapp.entity.UserEntity;

//package com.codewithswati.crmemps.service;

//import com.codewithswati.crmemps.dto.RegisterRequest;

public interface UsersService {
	UserEntity getUser(Long id);

    void register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
}


