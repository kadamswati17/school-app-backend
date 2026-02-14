package com.schoolapp.repository;

//import com.employeemanagement.entity.UserRoleDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolapp.entity.UserRoleDetails;

//import com.Crmemp.entity.UserRoleDetails;

public interface UserRoleDetailsRepository extends JpaRepository<UserRoleDetails, Long> {
}
