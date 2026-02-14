package com.schoolapp.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapp.entity.BusManagement;
import com.schoolapp.entity.District;

@Service
public class BusManagementService {
	@Autowired

	com.schoolapp.dao.BusManagementDao BusManagementDao;

	public BusManagement saveBusManagement(BusManagement BusManagement) {
		return BusManagementDao.saveBusManagement(BusManagement);
	}

	public String getAllBusManagement(BusManagement BusManagement) throws ClassNotFoundException, SQLException {
		return BusManagementDao.getAllBusManagement(BusManagement);
	}

	public BusManagement findBusManagementById(int BusManagementId) {
		return BusManagementDao.findBusManagementById(BusManagementId);
	}

	public BusManagement updateBusManagement(BusManagement BusManagementId) {
		Integer c = BusManagementId.getBusManagementId();

		BusManagement BusManagement = BusManagementDao.findBusManagementById(BusManagementId.getBusManagementId());
//		BusManagement.setNameOfVillage(BusManagementId.getNameOfVillage());
		BusManagement.setBusManagementId(BusManagementId.getBusManagementId());
		BusManagement.setDistanceFromVillage(BusManagementId.getDistanceFromVillage());
		BusManagement.setBusCharges(BusManagementId.getBusCharges()); 
		return BusManagementDao.saveBusManagement(BusManagement);
	}

	public String deleteBusManagementById(int BusManagementId) {
		BusManagementDao.deleteBusManagementById(BusManagementId);
		return "deleted";
	}
}
