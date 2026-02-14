package com.schoolapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.schoolapp.entity.ProductionRecipeMaster;
import com.schoolapp.repository.ProductionRecipeMasterRepo;

@Component
public class ProductionRecipeMasterDao {
	@Autowired
	ProductionRecipeMasterRepo ProductionRecipeMasterRepo;

	public ProductionRecipeMaster saveProductionRecipeMaster(ProductionRecipeMaster ProductionRecipeMaster)
			throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return ProductionRecipeMasterRepo.save(ProductionRecipeMaster);
	}

	public String getAllProductionRecipeMaster(ProductionRecipeMaster ProductionRecipeMaster) throws Exception {
		JSONArray result = new JSONArray();
		int orgId = ProductionRecipeMaster.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM  production_recipe_master where org_id=" + orgId);

		ResultSetMetaData md = resultSet.getMetaData();
		int numCols = md.getColumnCount();
		List<String> colNames = IntStream.range(0, numCols).mapToObj(i -> {
			try {
				return md.getColumnName(i + 1);
			} catch (SQLException e) {
				e.printStackTrace();
				return "?";
			}
		}).collect(Collectors.toList());

		while (resultSet.next()) {
			JSONObject row = new JSONObject();
			colNames.forEach(cn -> {
				try {
					row.put(cn, resultSet.getObject(cn));
				} catch (JSONException | SQLException e) {
					e.printStackTrace();
				}
			});
			result.put(row);
		}
		return "" + result;
	}

	public ProductionRecipeMaster updateDeleteProductionRecipeMaster(ProductionRecipeMaster ProductionRecipeMaster)
			throws ClassNotFoundException, SQLException {

		return ProductionRecipeMasterRepo.save(ProductionRecipeMaster);
	}

	public ProductionRecipeMaster findProductionRecipeMasterById(int ProductionRecipeMasterId) {
		return (ProductionRecipeMaster) ProductionRecipeMasterRepo.findById(ProductionRecipeMasterId).get();
	}

	public String deleteProductionRecipeMasterById(int ProductionRecipeMasterId) {
		ProductionRecipeMasterRepo.deleteById(ProductionRecipeMasterId);
		return "deleted";
	}
}
