package com.schoolapp.service;

//import com.Crmemp.dto.request.ProductionEntryRequest;
//import com.Crmemp.dto.request.ProductionImportRequest;
//import com.Crmemp.dto.request.ProductionImportResponse;
//import com.Crmemp.entity.ProductionEntry;

import java.util.List;
import java.util.Map;

import com.schoolapp.dao.ProductionEntryRequest;
import com.schoolapp.dao.ProductionImportRequest;
import com.schoolapp.dao.ProductionImportResponse;
import com.schoolapp.entity.ProductionEntry;

public interface ProductionEntryService {

	 ProductionEntry save(ProductionEntryRequest request);

	    ProductionEntry update(Long id, ProductionEntryRequest request);

//	    ProductionEntry approve(Long productionId);
//	    ProductionEntry approve(Long productionId, Long userId, String role);
	     ProductionEntry approve(Long productionId);
	     ProductionEntry reject(Long productionId, String reason);
	    List<ProductionEntry> getAll();

	    ProductionEntry getById(Long id);

	    void delete(Long id);
//	    ProductionEntry reject(Long productionId, String reason);
//	    ProductionEntry reject(Long productionId, Long userId, String role, String reason);
	    
	    ProductionImportResponse importProduction(ProductionImportRequest request);

	    Map<String, Object> importExcel(Map<String, Object> body);
	    List<Map<String, Object>> getDashboard();



}
