package com.schoolapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolapp.entity.PurchaseCartItems;
//
//import com.Crmemp.entity.PurchaseCartItems;
//import com.Crmemp.entity.PurchaseOrder;
import com.schoolapp.entity.PurchaseOrder;

//import com.employeemanagement.entity.PurchaseCartItems;
//import com.employeemanagement.entity.PurchaseOrder;

@Repository
public interface PurchaseCartItemsRepository extends JpaRepository<PurchaseCartItems, Long> {

    List<PurchaseCartItems> findByPurchaseOrder(PurchaseOrder purchaseOrder);
}
