//package com.schoolapp.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.schoolapp.entity.PurchaseOrder;
//import com.schoolapp.service.PurchaseOrderService;
//
//@RestController
//@RequestMapping("/api/admin")
//@CrossOrigin("*")
//public class AdminPurchaseOrderController {
//
//    private final PurchaseOrderService purchaseOrderService;
//
//    public AdminPurchaseOrderController(PurchaseOrderService purchaseOrderService) {
//        this.purchaseOrderService = purchaseOrderService;
//    }
//
//    // ================= CART =================
//
//    @PostMapping("/purchase-cart")
//    public String saveCartItem(@RequestBody Object cartItem) {
//        return "Cart item saved";
//    }
//
//    @DeleteMapping("/purchase-cart/{id}")
//    public String deleteCartItem(@PathVariable Long id) {
//        return "Cart item deleted";
//    }
//
//    // ================= ORDER =================
//
//    @PostMapping("/purchase-order/place")
//    public PurchaseOrder placeOrder(@RequestBody PurchaseOrder order) {
//        return purchaseOrderService.saveOrder(order);
//    }
//
//    @GetMapping("/purchase-orders")
//    public List<PurchaseOrder> getAllOrders() {
//        try {
//			return purchaseOrderService.getAllPurchaseOrder();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//    }
//
//    @GetMapping("/purchase-order/details/{id}")
//    public PurchaseOrder getOrderDetails(@PathVariable int id) {
//        return purchaseOrderService.findPurchaseOrderById(id);
//    }
//
//    @PutMapping("/purchase-order/status/{id}")
//    public String changeStatus(@PathVariable int id, @RequestParam String status) {
//        return "Status changed";
//    }
//}
//
//

package com.schoolapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.schoolapp.dao.PlacePurchaseOrderRequest;
import com.schoolapp.entity.PurchaseOrder;
import com.schoolapp.service.PurchaseOrderService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminPurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    public AdminPurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @PostMapping("/purchase-order/place")
    public List<PurchaseOrder> placeOrder(@RequestBody PlacePurchaseOrderRequest request) {
        return purchaseOrderService.placeOrder(request);
    }

 // ================= CART =================

    @PostMapping("/purchase-cart")
    public String saveCartItem(@RequestBody Object cartItem) {
        return "Cart item saved successfully";
    }

    @DeleteMapping("/purchase-cart/{id}")
    public String deleteCartItem(@PathVariable Long id) {
        return "Cart item deleted successfully " + id;
    }

    // ================= GET ALL =================
    @GetMapping("/purchase-orders")
    public List<PurchaseOrder> getAllOrders() {
        return purchaseOrderService.getAllPurchaseOrder();
    }

    // ================= GET BY ID =================
    @GetMapping("/purchase-order/details/{id}")
    public PurchaseOrder getOrderDetails(@PathVariable int id) {
        return purchaseOrderService.findPurchaseOrderById(id);
    }

    // ================= UPDATE =================
    @PutMapping("/purchase-order/update")
    public PurchaseOrder updateOrder(@RequestBody PurchaseOrder order) {
        return purchaseOrderService.updatePurchaseOrder(order);
    }

    // ================= DELETE =================
    @DeleteMapping("/purchase-order/{id}")
    public String deleteOrder(@PathVariable int id) {
        return purchaseOrderService.deletePurchaseOrderById(id);
    }
}

