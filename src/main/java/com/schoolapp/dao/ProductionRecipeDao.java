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

import com.schoolapp.entity.ProductionRecipe;
import com.schoolapp.repository.ProductionRecipeRepo;

@Component
public class ProductionRecipeDao {
	@Autowired
	ProductionRecipeRepo ProductionRecipeRepo;

	public ProductionRecipe saveProductionRecipe(ProductionRecipe ProductionRecipe)
			throws ClassNotFoundException, SQLException {
		System.out.println("Data inserted successfully...");
		return ProductionRecipeRepo.save(ProductionRecipe);
	}

	public String getAllProductionRecipe(ProductionRecipe ProductionRecipe) throws Exception {
		JSONArray result = new JSONArray();
		int orgId = ProductionRecipe.getOrgId();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erpdb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("SELECT * FROM  production_recipe where org_id=" + orgId);

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

	public ProductionRecipe updateDeleteProductionRecipe(ProductionRecipe ProductionRecipe)
			throws ClassNotFoundException, SQLException {

		return ProductionRecipeRepo.save(ProductionRecipe);
	}

	public ProductionRecipe findProductionRecipeById(int ProductionRecipeId) {
		return (ProductionRecipe) ProductionRecipeRepo.findById(ProductionRecipeId).get();
	}

	public String deleteProductionRecipeById(int ProductionRecipeId) {
		ProductionRecipeRepo.deleteById(ProductionRecipeId);
		return "deleted";
	}
}
