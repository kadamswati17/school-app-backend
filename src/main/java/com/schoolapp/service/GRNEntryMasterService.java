package com.schoolapp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapp.dao.GRNEntryMasterDao;
import com.schoolapp.dao.UserDao;
import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.GRNEntryMaster;
import com.schoolapp.entity.User;

@Service
public class GRNEntryMasterService {
	@Autowired
	GRNEntryMasterDao GRNEntryMasterDao;

	public GRNEntryMaster saveGRNEntryMaster(GRNEntryMaster GRNEntryMaster)
			throws ClassNotFoundException, SQLException {

		com.schoolapp.entity.GRNEntryMaster path = null;
		int userId = GRNEntryMaster.getUserId();

		User users = new User();
		users.setuId(userId);

		AccessPermission accessPermission = new AccessPermission();
		accessPermission.setAccessUserId(userId);

		List<Object> al = new ArrayList<>();

		UserDao userDao = new UserDao();

		al.add(userDao.userValidation(users, accessPermission));

		int valideSave = accessPermission.getAccessCreate();
		if (valideSave == 1) {
			path = GRNEntryMasterDao.saveGRNEntryMaster(GRNEntryMaster);

		} else {
			System.out.println("Invalide Credantials");
		}
		return path;

	}

	public String getAllGRNEntryMaster(GRNEntryMaster GRNEntryMaster) throws Exception {

		String path = null;
		int userId = GRNEntryMaster.getUserId();

		User users = new User();
		users.setuId(userId);

		AccessPermission accessPermission = new AccessPermission();
		accessPermission.setAccessUserId(userId);
		List<Object> al = new ArrayList<>();

		UserDao userDao = new UserDao();

		al.add(userDao.userValidation(users, accessPermission));

		int valideSave = accessPermission.getAccessCreate();
		if (valideSave == 1) {
			path = GRNEntryMasterDao.getAllGRNEntryMaster(GRNEntryMaster);

		} else {
			System.out.println("Invalide Credantials");
		}
		return path;
	}

	public String getAllStudentClassWise(GRNEntryMaster GRNEntryMaster) throws Exception {

		String path = null;
		int userId = GRNEntryMaster.getUserId();

		User users = new User();
		users.setuId(userId);

		AccessPermission accessPermission = new AccessPermission();
		accessPermission.setAccessUserId(userId);
		List<Object> al = new ArrayList<>();

		UserDao userDao = new UserDao();

		al.add(userDao.userValidation(users, accessPermission));

		int valideSave = accessPermission.getAccessCreate();
		if (valideSave == 1) {
			path = GRNEntryMasterDao.getAllGRNEntryMaster(GRNEntryMaster);

		} else {
			System.out.println("Invalide Credantials");
		}
		return path;
	}

	public GRNEntryMaster findGRNEntryMasterById(int GRNEntryMasterID) {
		return GRNEntryMasterDao.findGRNEntryMasterById(GRNEntryMasterID);
	}

	public GRNEntryMaster updateDeleteGRNEntryMaster(GRNEntryMaster GRNEntryMaster)
			throws ClassNotFoundException, SQLException {

		return GRNEntryMasterDao.updateDeleteGRNEntryMaster(GRNEntryMaster);
	}

	public String deleteGRNEntryMasterById(int GRNEntryMasterID) {
		GRNEntryMasterDao.deleteGRNEntryMasterById(GRNEntryMasterID);
		return "deleted";
	}
}
