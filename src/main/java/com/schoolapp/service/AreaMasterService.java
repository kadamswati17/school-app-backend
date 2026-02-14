package com.schoolapp.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapp.dao.AreaMasterDao;
import com.schoolapp.dao.UserDao;
import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.AreaMaster;
import com.schoolapp.entity.User;

@Service
public class AreaMasterService {
	@Autowired
	AreaMasterDao areaMasterDao;

	public AreaMaster saveAreaMaster(AreaMaster areaMaster) throws ClassNotFoundException, SQLException {

		AreaMaster path = null;
		int userId = areaMaster.getUserId();

		User users = new User();
		users.setuId(userId);

		AccessPermission accessPermission = new AccessPermission();
		accessPermission.setAccessUserId(userId);

		List<Object> al = new ArrayList<>();

		UserDao userDao = new UserDao();

		al.add(userDao.userValidation(users, accessPermission));

		int valideSave = accessPermission.getAccessCreate();
		if (valideSave == 1) {

			path = areaMasterDao.saveAreaMaster(areaMaster);

		} else {
			System.out.println("Invalide Credantials");
		}
		return path;
	}

	public List<AreaMaster> getAllAreaMaster() throws Exception {
		return areaMasterDao.getAllAreaMaster();
	}

	public AreaMaster findAreaMasterById(int AreaMasterId) {
		return areaMasterDao.findAreaMasterById(AreaMasterId);
	}

	public AreaMaster updateAreaMaster(AreaMaster areaMaster) throws ClassNotFoundException, SQLException {
		Integer areaMasterId = areaMaster.getAreaMasterId();
		AreaMaster accounts = areaMasterDao.findAreaMasterById(areaMaster.getAreaMasterId());
		accounts.setUserId(areaMaster.getUserId());
		accounts.setCreatedDate(areaMaster.getCreatedDate());
		accounts.setUpdatedBy(areaMaster.getUpdatedBy());
		accounts.setUpdatedDate(areaMaster.getUpdatedDate());
		accounts.setBranchId(areaMaster.getBranchId());
		accounts.setOrgId(areaMaster.getOrgId());
		accounts.setIsActive(areaMaster.getIsActive());

		return areaMasterDao.saveAreaMaster(accounts);
	}

	public AreaMaster updateDeleteAreaMaster(AreaMaster areaMaster) throws ClassNotFoundException, SQLException {
		AreaMaster path = null;
		int userId = areaMaster.getUserId();

		User users = new User();
		users.setuId(userId);

		AccessPermission accessPermission = new AccessPermission();
		accessPermission.setAccessUserId(userId);

		List<Object> al = new ArrayList<>();

		UserDao userDao = new UserDao();

		al.add(userDao.userValidation(users, accessPermission));

		int valideSave = accessPermission.getAccessUpdate();
		System.out.println(valideSave);

		if (valideSave == 1) {
			System.out.println("Updation Done");
			path = areaMasterDao.updateDeleteAreaMaster(areaMaster);

		} else {
			System.out.println("Invalide Credantials");
		}
		return path;

	}

	public String deleteAreaMasterById(int areaMasterId) {
		areaMasterDao.deleteAreaMasterById(areaMasterId);
		return "deleted";
	}
}
