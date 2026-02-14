package com.schoolapp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapp.dao.UserDao;
import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.LeadAccounts;
import com.schoolapp.entity.Site;
import com.schoolapp.entity.Unit;
import com.schoolapp.entity.User;
import com.schoolapp.entity.UserEntity;
import com.schoolapp.repository.UserRepository;

@Service
public class UserService {

    private final UserDao userDao;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserDao userDao, UserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    // =========================================================
    // ✅ CREATE USER WITH PARENT ID (NO SECURITY)
    // =========================================================
    public UserEntity createUser(UserEntity user) {

        Long creatorId = user.getParentId();   // send this from UI

        UserEntity creator = userRepository.findById(creatorId)
                .orElseThrow(() -> new RuntimeException("Creator not found"));

        user.setParentId(creator.getId());

        return userRepository.save(user);
    }


    // =========================================================
    // SAVE USER (OLD LOGIC KEPT)
    // =========================================================
    public UserEntity saveUser(UserEntity user)
            throws ClassNotFoundException, SQLException {

        return userDao.saveUser(user);
    }

    // =========================================================
    // GET ALL USERS WITH ACCESS CHECK
    // =========================================================
    public String getAllUser(User user)
            throws ClassNotFoundException, SQLException {

        int userId = user.getUserId();

        User users = new User();
        users.setuId(userId);

        AccessPermission accessPermission = new AccessPermission();
        accessPermission.setAccessUserId(userId);

        userDao.userValidation(users, accessPermission);

        if (accessPermission.getAccessCreate() == 1) {
            return userDao.getAllUser(user);
        }

        return "Invalid Credentials";
    }

    // =========================================================
    public String valideUserDetailes(User users)
            throws ClassNotFoundException, SQLException {
        return userDao.valideUserDetailes(users);
    }

    public AccessPermission userValidation(User users,
                                           AccessPermission accessPermission)
            throws ClassNotFoundException, SQLException {
        return userDao.userValidation(users, accessPermission);
    }

    // =========================================================
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    // =========================================================
    // UPDATE USER WITH ACCESS CHECK
    // =========================================================
    public String updateUser(User user)
            throws ClassNotFoundException, SQLException {

        int userId = user.getUserId();

        User users = new User();
        users.setuId(userId);

        AccessPermission accessPermission = new AccessPermission();
        accessPermission.setAccessUserId(userId);

        userDao.userValidation(users, accessPermission);

        if (accessPermission.getAccessUpdate() == 1) {
            return userDao.updateUser(user);
        }

        return "Invalid Credentials";
    }

    // =========================================================
    public String updateDeleteUser(User users)
            throws ClassNotFoundException, SQLException {

        int userId = users.getUserId();

        AccessPermission accessPermission = new AccessPermission();
        accessPermission.setAccessUserId(userId);

        userDao.userValidation(users, accessPermission);

        if (accessPermission.getAccessUpdate() == 1) {
            return userDao.updateDeleteUser(users);
        }

        return "Invalid Credentials";
    }

    // =========================================================
    // FULL UPDATE OBJECT (OLD LOGIC KEPT)
    // =========================================================
    public User updateUsers(User user)
            throws ClassNotFoundException, SQLException {

        User existing = userDao.findUserById(user.getuId());

        existing.setUserSrNo(user.getUserSrNo());
        existing.setUserName(user.getUserName());
        existing.setBranchId(user.getBranchId());
        existing.setOrgId(user.getOrgId());
        existing.setDate(user.getDate());
        existing.setUserContact(user.getUserContact());
        existing.setPanNo(user.getPanNo());
        existing.setGstNo(user.getGstNo());
        existing.setEmail(user.getEmail());
        existing.setPhone(user.getPhone());
        existing.setuAddress(user.getuAddress());
        existing.setIncome(user.getIncome());
        existing.setIncomeSource(user.getIncomeSource());
        existing.setOtherIncome(user.getOtherIncome());
        existing.setOtherIncomeSource(user.getOtherIncomeSource());
        existing.setNotes(user.getNotes());
        existing.setIsActive(user.getIsActive());
        existing.setStateId(user.getStateId());
        existing.setDistId(user.getDistId());
        existing.setCityId(user.getCityId());
        existing.setUserId(user.getUserId());
        existing.setCreatedDate(user.getCreatedDate());
        existing.setUpdatedBy(user.getUpdatedBy());
        existing.setUpdatedDate(user.getUpdatedDate());

        return userDao.saveUser(existing);
    }

    // =========================================================
    public String deleteUserById(int userId) {
        userDao.deleteUserById(userId);
        return "deleted";
    }

    // =========================================================
    // ⭐ ROLE BASED (FROM SECOND SERVICE)
    // =========================================================
    public List<UserEntity> getParties() {
        return userRepository.findByRole("ROLE_PARTY_NAME");
    }

    public List<UserEntity> listAllExcept(Long excludeId) {
        return userRepository.findAllExcept(excludeId);
    }

    public UserEntity getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}

