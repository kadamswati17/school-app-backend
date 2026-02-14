package com.schoolapp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapp.entity.TcMaster;

@Service
public class TcMasterService {
	@Autowired
	com.schoolapp.dao.TcMasterDao TcMasterDao;

	public TcMaster saveTcMaster(TcMaster TcMaster) throws ClassNotFoundException, SQLException {
		return TcMasterDao.saveTcMaster(TcMaster);
	}

	public String getAllTcMaster(TcMaster TcMaster) throws ClassNotFoundException, SQLException {
		return TcMasterDao.getAllTcMaster(TcMaster);
	}

	public TcMaster findTcMasterById(int TcMasterId) {
		return TcMasterDao.findTcMasterById(TcMasterId);
	}

	public TcMaster updateTcMaster(TcMaster TcMaster) throws ClassNotFoundException, SQLException {
		return TcMasterDao.saveTcMaster(TcMaster);
	}

	public String deleteTcMasterById(int TcMasterId) {
		TcMasterDao.deleteTcMasterById(TcMasterId);
		return "deleted";
	}
}
