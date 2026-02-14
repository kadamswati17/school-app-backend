//package com.schoolapp.service;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.schoolapp.dao.PurchaseOrderDao;
//import com.schoolapp.dao.PurchaseOrderMasterDao;
//
//
//import com.schoolapp.dao.UserDao;
//import com.schoolapp.entity.AccessPermission;
//import com.schoolapp.entity.PurchaseOrder;
//
//
//import com.schoolapp.entity.User;
//import com.schoolapp.repository.PurchaseOrderRepository;
//
//@Service
//public class PurchaseOrderService {
//
//    private final PurchaseOrderRepository purchaseOrderRepository;
//
//    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository) {
//        this.purchaseOrderRepository = purchaseOrderRepository;
//    }
//
//
//	@Autowired
//	PurchaseOrderDao purchaseOrderDao;
////	private PurchaseOrderRepository purchaseOrderRepository;
//	int existInqMst = 0;
//
//	public List<PurchaseOrder> savePurchaseOrder(List<PurchaseOrder> purchaseOrder)
//			throws ClassNotFoundException, SQLException {
//		
//		List<PurchaseOrder> path = null;
//		int userId = 0;
//		int flag = 0;
//
//		for (PurchaseOrder al : purchaseOrder) {
//			if (flag == 0) {
//				flag = 1;
//				userId = al.getUserId();
//			}
//		}
//
//
//		User users = new User();
//		users.setuId(userId);
//
//		AccessPermission accessPermission = new AccessPermission();
//		accessPermission.setAccessUserId(userId);
//
//		List<Object> al = new ArrayList<>();
//
//		UserDao userDao = new UserDao();
//
//		al.add(userDao.userValidation(users, accessPermission));
//
//		int valideSave = accessPermission.getAccessCreate();
//		if (valideSave == 1) {
//			// path = workOrderRepo.save(workOrder);
//			path = purchaseOrderDao.savePurchaseOrder(purchaseOrder);
//
//		} else {
//			System.out.println("Invalide Credantials");
//		}
//		return path;
//
//	}
//
//	public PurchaseOrder updateDeletePurchaseOrder(PurchaseOrder purchaseOrder)
//			throws ClassNotFoundException, SQLException {
//		PurchaseOrder path = null;
//		int userId = purchaseOrder.getUserId();
//
//		User users = new User();
//		users.setuId(userId);
//
//		AccessPermission accessPermission = new AccessPermission();
//		accessPermission.setAccessUserId(userId);
//
//		List<Object> al = new ArrayList<>();
//
//		UserDao userDao = new UserDao();
//
//		al.add(userDao.userValidation(users, accessPermission));
//
//		int valideSave = accessPermission.getAccessUpdate();
////		System.out.println(valideSave);
//
//		if (valideSave == 1) {
//			path = purchaseOrderDao.updateDeletePurchaseOrder(purchaseOrder);
//
//		} else {
//			System.out.println("Invalide Credantials");
//		}
//		return path;
//	}
//
//	public List<PurchaseOrder> getAllPurchaseOrder() throws Exception {
//		return purchaseOrderDao.getAllPurchaseOrder();
//	}
//
//	public PurchaseOrder findPurchaseOrderById(int purchaseOrderId) {
//		return purchaseOrderDao.findPurchaseOrderById(purchaseOrderId);
//	}
//
//	public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder)
//			throws ClassNotFoundException, SQLException {
//		Integer purchaseOrderId = purchaseOrder.getPurchaseOrderId();
//		PurchaseOrder purchaseD = purchaseOrderDao.findPurchaseOrderById(purchaseOrder.getPurchaseOrderId());
//		purchaseD.setPurchaseDate(purchaseOrder.getPurchaseDate());
//		purchaseD.setCustomerId(purchaseOrder.getCustomerId());
//		purchaseD.setPurchaseOrderId(purchaseOrder.getPurchaseOrderId());
//		purchaseD.setProductId(purchaseOrder.getProductId());
//		purchaseD.setPartiCulars(purchaseOrder.getPartiCulars());
//		purchaseD.setRate(purchaseOrder.getRate());
//		purchaseD.setQuantity(purchaseOrder.getQuantity());
//		purchaseD.setDiscount(purchaseOrder.getDiscount());
//		purchaseD.setAmount(purchaseOrder.getAmount());
//		purchaseD.setTotal(purchaseOrder.getTotal());
//		purchaseD.setGrandTotal(purchaseOrder.getGrandTotal());
//		purchaseD.setMrp(purchaseOrder.getMrp());
//		purchaseD.setScheme(purchaseOrder.getScheme());
//		purchaseD.setCgst(purchaseOrder.getCgst());
//		purchaseD.setSgst(purchaseOrder.getSgst());
//		purchaseD.setCgstPer(purchaseOrder.getCgstPer());
//		purchaseD.setSgstPer(purchaseOrder.getSgstPer());
//		purchaseD.setIgst(purchaseOrder.getIgst());
//		purchaseD.setIgstPer(purchaseOrder.getIgstPer());
//		purchaseD.setDcn(purchaseOrder.getDcn());
//		purchaseD.setUserId(purchaseOrder.getUserId());
//		purchaseD.setOrgId(purchaseOrder.getOrgId());
//		purchaseD.setBranchId(purchaseOrder.getBranchId());
//		purchaseD.setCreatedDate(purchaseOrder.getCreatedDate());
//		purchaseD.setUpdatedBy(purchaseOrder.getUpdatedBy());
//		purchaseD.setUpdatedDate(purchaseOrder.getUpdatedDate());
//		purchaseD.setIsActive(purchaseOrder.getIsActive());
//
//		return purchaseOrderDao.updateDeletePurchaseOrder(purchaseD);
//	}
//
//	public String deletePurchaseOrderById(int purchaseOrderId) {
//		purchaseOrderDao.deletePurchaseOrderById(purchaseOrderId);
//		return "deleted";
//	}
//	
//	public PurchaseOrder saveOrder(PurchaseOrder order) {
//
//	    order.setPurchaseDate(new java.sql.Date(System.currentTimeMillis()));
//	    order.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
//	    order.setIsActive(1);
//
//	    return purchaseOrderRepository.save(order);
//	}
//}
package com.schoolapp.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolapp.dao.CartItemsDto;
import com.schoolapp.dao.PlacePurchaseOrderRequest;
import com.schoolapp.entity.PurchaseOrder;
import com.schoolapp.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }

    // ================= SAVE SINGLE =================
    public PurchaseOrder saveOrder(PurchaseOrder order) {

        order.setPurchaseDate(new Date(System.currentTimeMillis()));
        order.setCreatedDate(new Date(System.currentTimeMillis()));
        order.setIsActive(1);

        return purchaseOrderRepository.save(order);
    }

    // ================= SAVE LIST =================
    public List<PurchaseOrder> saveOrders(List<PurchaseOrder> orders) {

        for (PurchaseOrder order : orders) {
            order.setPurchaseDate(new Date(System.currentTimeMillis()));
            order.setCreatedDate(new Date(System.currentTimeMillis()));
            order.setIsActive(1);
        }

        return purchaseOrderRepository.saveAll(orders);
    }

    // ================= GET ALL =================
    public List<PurchaseOrder> getAllPurchaseOrder() {
        return purchaseOrderRepository.findAll();
    }

    // ================= GET BY ID =================
    public PurchaseOrder findPurchaseOrderById(int id) {
        return purchaseOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // ================= UPDATE =================
    public PurchaseOrder updatePurchaseOrder(PurchaseOrder order) {

        PurchaseOrder existing = findPurchaseOrderById(order.getPurchaseOrderId());

        existing.setProductId(order.getProductId());
        existing.setProduct(order.getProduct());
        existing.setQuantity(order.getQuantity());
        existing.setRate(order.getRate());
        existing.setTotal(order.getTotal());
        existing.setGrandTotal(order.getGrandTotal());

        return purchaseOrderRepository.save(existing);
    }

    // ================= DELETE =================
    public String deletePurchaseOrderById(int id) {
        purchaseOrderRepository.deleteById(id);
        return "Deleted successfully";
    }
    
    public List<PurchaseOrder> placeOrder(PlacePurchaseOrderRequest request) {

        List<PurchaseOrder> list = new ArrayList<>();

        for (CartItemsDto item : request.getCartItems()) {

            PurchaseOrder order = new PurchaseOrder();

            order.setUserId(request.getUserId().intValue());
            order.setProductId(item.getProductId().intValue());
            order.setProduct(item.getProductName());
            order.setRate((float) item.getPrice());
            order.setQuantity((float) item.getQuantity());

            order.setPurchaseDate(new java.sql.Date(System.currentTimeMillis()));
            order.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
            order.setIsActive(1);

            list.add(order);
        }

        return purchaseOrderRepository.saveAll(list);
    }


}
