package com.schoolapp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapp.dao.PurchaseOrderMasterDao;

import com.schoolapp.dao.UserDao;
import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.PurchaseOrderMaster;

import com.schoolapp.entity.User;


@Service
public class PurchaseOrderMasterService {


	@Autowired
	PurchaseOrderMasterDao purchaseOrderMasterDao;

	public PurchaseOrderMaster savePurchaseMst(PurchaseOrderMaster purchaseOrderMaster) throws ClassNotFoundException, SQLException {
		PurchaseOrderMaster path = null;
		int userId = purchaseOrderMaster.getUserId();

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
			path = purchaseOrderMasterDao.savePurchaseOrderMaster(purchaseOrderMaster);

		} else {
			System.out.println("Invalide Credantials");
		}
		return path;

	}

	public PurchaseOrderMaster updateDeletePurchaseOrderMaster(PurchaseOrderMaster purchaseOrderMaster)
			throws ClassNotFoundException, SQLException {
		PurchaseOrderMaster path = null;
		int userId = purchaseOrderMaster.getUserId();

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
			path = purchaseOrderMasterDao.updateDeletePurchaseOrderMaster(purchaseOrderMaster);

		} else {
			System.out.println("Invalide Credantials");
		}
		return path;
	}

	public String getAllPurchaseMst(PurchaseOrderMaster purchaseOrderMaster) throws ClassNotFoundException, SQLException {
		return purchaseOrderMasterDao.getAllPurchase(purchaseOrderMaster);
	}

	public PurchaseOrderMaster findPurchaseById(int InqId) {

		return purchaseOrderMasterDao.findPurchaseById(InqId);
	}

	public PurchaseOrderMaster updatePurchase(PurchaseOrderMaster purchaseOrderMaster) throws ClassNotFoundException, SQLException {
 

		return purchaseOrderMasterDao.savePurchaseOrderMaster(purchaseOrderMaster);
	}

	public String deletePurchaseById(int InqId) {
		purchaseOrderMasterDao.deletePurchaseByID(InqId);
		return "deleted";
	}
}
