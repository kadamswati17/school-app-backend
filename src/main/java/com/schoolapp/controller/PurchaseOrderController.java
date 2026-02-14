package com.schoolapp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolapp.entity.PurchaseOrder;


import com.schoolapp.service.PurchaseOrderService;



@RestController
@RequestMapping("/PurchaseOrder")
@CrossOrigin(origins = "*")
public class PurchaseOrderController {

	@Autowired
	PurchaseOrderService purchaseOrderService;

	@PostMapping("/save")
	public List<PurchaseOrder> savePurchaseOrder(@RequestBody List<PurchaseOrder> purchaseOrder)
			throws ClassNotFoundException, SQLException {
		
		return purchaseOrderService.saveOrders(purchaseOrder);
	}

	@GetMapping("/getAll")
	public List<PurchaseOrder> getAllPurchaseOrder() throws Exception {
		return purchaseOrderService.getAllPurchaseOrder();
	}

	//
	@GetMapping("/get")
	public PurchaseOrder findPurchaseOrderById(@RequestBody PurchaseOrder purchaseOrder) {

		return purchaseOrderService.findPurchaseOrderById(purchaseOrder.getPurchaseOrderId());
		// return State;
	}

	@PutMapping("/updateDeletePurchaseOrder")
	public String updateDeletePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder)
			throws ClassNotFoundException, SQLException {
		purchaseOrderService.updatePurchaseOrder(purchaseOrder);
		return "Record Updated.....";
	}

	@PutMapping("/update")
	public String updatePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder)
			throws ClassNotFoundException, SQLException {
		purchaseOrderService.updatePurchaseOrder(purchaseOrder);
		return "Record Updated.....";
	}

	// http://192.168.43.146:8080/leadAccounts/getAll
	@DeleteMapping("/delete")
	public String deletePurchaseOrderById(@RequestBody PurchaseOrder purchaseOrder) {
		int id = purchaseOrder.getPurchaseOrderId();

		if (id > 0) {
			purchaseOrderService.deletePurchaseOrderById(id);
			return "deleted....." + id;
		}

		return "Wrong ID" + id;
	}
}

