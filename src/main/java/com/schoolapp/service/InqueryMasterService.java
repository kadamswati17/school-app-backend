package com.schoolapp.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapp.dao.InqueryMasterDao;
import com.schoolapp.dao.UserDao;
import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.Contractor;
import com.schoolapp.entity.Floor;
import com.schoolapp.entity.InqueryMaster;
import com.schoolapp.entity.User;

@Service
public class InqueryMasterService {

	@Autowired
	InqueryMasterDao inqueryMasterDao;

	public InqueryMaster saveInqueryMst(InqueryMaster inqueryMaster) throws ClassNotFoundException, SQLException {
		InqueryMaster path = null;
		int userId = inqueryMaster.getUserId();

		User users = new User();
		users.setuId(userId);

		AccessPermission accessPermission = new AccessPermission();
		accessPermission.setAccessUserId(userId);

		List<Object> al = new ArrayList<>();

		UserDao userDao = new UserDao();

		al.add(userDao.userValidation(users, accessPermission));

		int valideSave = accessPermission.getAccessCreate();
		if (valideSave == 1) {
			// path = workOrderRepo.save(workOrder);
			path = inqueryMasterDao.saveInqueryMaster(inqueryMaster);

		} else {
			System.out.println("Invalide Credantials");
		}
		return path;

	}

	public InqueryMaster updateDeleteInqueryMaster(InqueryMaster inqueryMaster)
			throws ClassNotFoundException, SQLException {
		InqueryMaster path = null;
		int userId = inqueryMaster.getUserId();

		User users = new User();
		users.setuId(userId);

		AccessPermission accessPermission = new AccessPermission();
		accessPermission.setAccessUserId(userId);

		List<Object> al = new ArrayList<>();

		UserDao userDao = new UserDao();

		al.add(userDao.userValidation(users, accessPermission));

		int valideSave = accessPermission.getAccessUpdate();
//		System.out.println(valideSave);

		if (valideSave == 1) {
			path = inqueryMasterDao.updateDeleteInqueryMaster(inqueryMaster);

		} else {
			System.out.println("Invalide Credantials");
		}
		return path;
	}

	public List<InqueryMaster> getAllInquermst() {
		return inqueryMasterDao.getAllInquery();
	}

	public InqueryMaster findInqueryById(int InqId) {

		return inqueryMasterDao.findInqueryById(InqId);
	}

	public InqueryMaster updateInquery(InqueryMaster inqueryMaster) throws ClassNotFoundException, SQLException {
		Integer integer = inqueryMaster.getInqueryId();
		InqueryMaster Inq = inqueryMasterDao.findInqueryById(inqueryMaster.getInqueryId());
		Inq.setInqueryId(inqueryMaster.getInqueryId());
		Inq.setDate(inqueryMaster.getDate());
		Inq.setLeadAccount(inqueryMaster.getInqueryId());
		Inq.setTotal(inqueryMaster.getInqueryId());
		Inq.setSrno(inqueryMaster.getSrno());
		Inq.setUpdatedBy(inqueryMaster.getInqueryId());
		Inq.setBranchId(inqueryMaster.getInqueryId());
		Inq.setCreatedDate(inqueryMaster.getCreatedDate());
		Inq.setUpdatedBy(inqueryMaster.getInqueryId());
		Inq.setUpdatedDate(inqueryMaster.getUpdatedDate());
		Inq.setIsActive(inqueryMaster.getInqueryId());

		return inqueryMasterDao.saveInqueryMaster(inqueryMaster);
	}

	public String deleteInqueryById(int InqId) {
		inqueryMasterDao.deleteInqueryByID(InqId);
		return "deleted";
	}
}
