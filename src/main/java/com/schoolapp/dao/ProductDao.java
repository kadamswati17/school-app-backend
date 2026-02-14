package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.AccessPermission;
import com.schoolapp.entity.Floor;
import com.schoolapp.entity.LeadAccounts;
import com.schoolapp.entity.Organization;
import com.schoolapp.entity.Product;
import com.schoolapp.entity.User;
import com.schoolapp.repository.ProductRepo;

@Component
public class ProductDao {
	@Autowired
	ProductRepo productRepo;

	public Product saveProduct(Product product) throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return productRepo.save(product);
	}

	public String updateProduct(Product product) throws SQLException, ClassNotFoundException {
		Integer productId = product.getProductId();

		String name = product.getName();
		String unit = product.getUnit();
		int userId = product.getUserId();
		float quantity = product.getQuantity();
		float rate = product.getRate();
		float d1 = product.getD1();
		float d2 = product.getD2();
		String itmType = product.getItmType();
		String shrtnm = product.getShrtnm();
		String productdiscription = product.getProductdiscription();
		float cgst = product.getCgst();
		float sgst = product.getSgst();
		float igst = product.getIgst();
		float purchaseRate = product.getPurchaseRate();
		String hsncode = product.getHsncode();
		int category = product.getCategory();
		int categoryID = product.getCategoryID();
		int brandId = product.getBrandId();
		float wrates = product.getWrates();
		int brId = product.getBrId();
		int orgId = product.getOrgId();
		int custId = product.getCustId();
		int isActive = product.getIsActive();
		Date createdDate = product.getCreatedDate();
		int updatedBy = product.getUserId();
		Date updatedDate = product.getUpdatedDate();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update product set"
				+ "br_id= ? , "
				+ "brand_id= ? , "
				+ "category= ? , "
				+ "categoryid= ? , "
				+ "cgst= ? , "
				+ "cust_id= ? , "
				+ "d1= ? ,"
				+ " d2= ? , "
				+ "hsncode= ? , "
				+ "igst= ? , "
				+ "itm_type= ? , "
				+ "name= ? , "
				+ "org_id= ? ,"
				+ " productdiscription= ? ,"
				+ " purchase_rate= ? , "
				+ "quantity= ? ,"
				+ " rate= ? , "
				+ "sgst= ? ,"
				+ " shrtnm= ? , "
				+ "unit= ?,"
				+ "user_id=? ,"
				+ " wrates= ? , "
				+ "created_date= ? , "
				+ "updated_by= ? , "
				+ "updated_date= ? , "
				+ "is_active=? where "
				+ "product_id= ? and "
				+ "org_id=?";

		PreparedStatement ps = con.prepareStatement(query);

		ps.setInt(1, brId);
		ps.setInt(2, brandId);
		ps.setInt(3, category);
		ps.setInt(4, categoryID);
		ps.setFloat(5, cgst);
		ps.setInt(6, custId);
		ps.setFloat(7, d1);
		ps.setFloat(8, d2);
		ps.setString(9, hsncode);
		ps.setFloat(10, igst);
		ps.setString(11, itmType);
		ps.setString(12, name);
		ps.setInt(13, orgId);
		ps.setString(14, productdiscription);
		ps.setFloat(15, purchaseRate);
		ps.setFloat(16, quantity);
		ps.setFloat(17, rate);
		ps.setFloat(18, sgst);
		ps.setString(19, shrtnm);
		ps.setString(20, unit);
		ps.setInt(21, userId);
		ps.setFloat(22, wrates);
		ps.setDate(23, createdDate);
		ps.setInt(24, updatedBy);
		ps.setDate(25, updatedDate);
		ps.setInt(26, isActive);
		ps.setInt(27, productId);
		ps.setInt(28, orgId);

		ps.executeUpdate();

		System.out.println("Record updated successfully..!");
		return "Record updated..!";

	}

	public Product updateDeleteProduct(Product product) throws ClassNotFoundException, SQLException {
		Integer productId = product.getProductId();
//		Contractor accounts = contractorDao.findContractorById(contractor.getContractorId());

		int userId = product.getUserId();
		int updatedBy = product.getUpdatedBy();
		Date updatedDate = product.getUpdatedDate();
		int branchId = product.getBrandId();
		int orgId = product.getOrgId();
		int isActive = product.getIsActive();

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		String query = "update product set is_active=?, updated_by=?,updated_date=? "
				+ "where product_id=? and org_id=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, isActive);
		ps.setInt(2, updatedBy);
		ps.setDate(3, (java.sql.Date) updatedDate);
		ps.setInt(4, productId);
		ps.setInt(5, orgId);
		ps.executeUpdate();
		System.out.println("Record updated");
		return productRepo.save(product);
	}

	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	public Product findProductById(int Product) {
		return productRepo.findById(Product).get();
	}

	public String deleteProductById(int Product) {
		productRepo.deleteById(Product);
		return "deleted";
	}

}
