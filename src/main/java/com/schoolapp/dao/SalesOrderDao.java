package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.SalesOrder;
import com.schoolapp.entity.StdTransactionDetailes;
import com.schoolapp.repository.SalesOrderRepo;

@Component
public class SalesOrderDao {

	@Autowired
	SalesOrderRepo salesOrderRepo;

	int existInqMst = 0;

	public List<SalesOrder> saveSalesOrder(List<SalesOrder> salesOrder) throws ClassNotFoundException, SQLException {

		for (SalesOrder al2 : salesOrder) {

			int srValide = al2.getSalesOrderMstId();

			if (srValide == 0) {

				Date salesDate = al2.getSalesDate();
				int customerId = al2.getCustomerId();
				int userId = al2.getUserId();
				int orgId = al2.getOrgId();
				int branchId = al2.getBranchId();
				Date createdDate = al2.getCreatedDate();
				int updatedBy = al2.getUpdatedBy();
				Date updatedDate = al2.getUpdatedDate();
				int isActive = al2.getIsActive();
				int srNo = 0;
				int total = 0;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");

				String sql = "INSERT INTO sales_order_master( date, customer_id, branch_id, created_date, is_active, org_id,   updated_by, updated_date, user_id,srno,total) "
						+ "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?,?,?)";

				PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				pst.setDate(1, salesDate);
				pst.setInt(2, customerId);
				pst.setInt(3, branchId);
				pst.setDate(4, createdDate);
				pst.setInt(5, isActive);
				pst.setInt(6, orgId);
				pst.setInt(7, updatedBy);
				pst.setDate(8, updatedDate);
				pst.setInt(9, userId);
				pst.setInt(10, srNo);
				pst.setInt(11, total);
				pst.executeUpdate();

				ResultSet rs = pst.getGeneratedKeys();
				int salesOrderId = -1;
				if (rs.next()) {
					salesOrderId = rs.getInt(1);
				}
				for (SalesOrder al3 : salesOrder) {
					al3.setSalesOrderMstId(salesOrderId);
					existInqMst = salesOrderId;
				}
			}

			System.out.println("Data inserted successfully...");
			return salesOrderRepo.saveAll(salesOrder);
		}
		return salesOrder;
	}

	public SalesOrder updateDeleteSalesOrder(SalesOrder salesOrder) throws ClassNotFoundException, SQLException {
		Integer salesOrderId = salesOrder.getSalesOrderId();
		int userId = salesOrder.getUserId();
		int updatedBy = salesOrder.getUpdatedBy();
		Date updatedDate = salesOrder.getUpdatedDate();
		int branchId = salesOrder.getBranchId();
		int orgId = salesOrder.getOrgId();
		int isActive = salesOrder.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update sales_detailes set is_active=?, updated_by=?,updated_date=? "
				+ "where sales_detailes_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, updatedDate);
		ps.setInt(4, salesOrderId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return salesOrderRepo.save(salesOrder);
	}

	public List<SalesOrder> getAllSalesOrder() throws Exception {

		return salesOrderRepo.findAll();
	}

	public SalesOrder findSalesOrderById(int SalesOrderId) {
		return (SalesOrder) salesOrderRepo.findById(SalesOrderId).get();
	}

	public String deleteSalesOrderById(int SalesOrderId) {
		salesOrderRepo.deleteById(SalesOrderId);
		return "deleted";
	}
}
