package com.schoolapp.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.schoolapp.dao.PlaceSellOrderRequest;
import com.schoolapp.dao.SellOrderDto;
import com.schoolapp.entity.SellCartItems;
import com.schoolapp.entity.SellOrder;
import com.schoolapp.entity.UserEntity;
import com.schoolapp.enums.OrderStatus;
import com.schoolapp.repository.SellCartItemsRepository;
import com.schoolapp.repository.SellOrderRepository;
import com.schoolapp.repository.UserRepository;

//import com.Crmemp.dto.request.PlaceSellOrderRequest;
//import com.Crmemp.dto.request.SellOrderDto;
//import com.Crmemp.entity.SellCartItems;
//import com.Crmemp.entity.SellOrder;
//import com.Crmemp.entity.User;
//import com.Crmemp.enums.OrderStatus;
//import com.Crmemp.repository.SellCartItemsRepository;
//import com.Crmemp.repository.SellOrderRepository;
//import com.Crmemp.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
public class SellOrderController {

    private final SellOrderRepository orderRepo;
    private final SellCartItemsRepository cartRepo;
    private final UserRepository userRepo;

    public SellOrderController(
            SellOrderRepository orderRepo,
            SellCartItemsRepository cartRepo,
            UserRepository userRepo) {
        this.orderRepo = orderRepo;
        this.cartRepo = cartRepo;
        this.userRepo = userRepo;
    }

    // ================= PLACE SELL ORDER =================
    @PostMapping("/sell-order/place")
    public ResponseEntity<SellOrderDto> placeOrder(
            @RequestBody PlaceSellOrderRequest req) {

        SellOrder order = new SellOrder();
        order.setOrderDescription(req.getOrderDescription());
        order.setDate(LocalDateTime.now());
        order.setTrackingId(UUID.randomUUID());
        order.setOrderStatus(OrderStatus.PROCESSING);

        if (req.getUserId() != null) {
            UserEntity user = userRepo.findById(req.getUserId()).orElse(null);
            order.setUser(user);
        }

        List<SellCartItems> items = req.getCartItems().stream().map(ci -> {
            SellCartItems sc = new SellCartItems();
            sc.setProductId(ci.getProductId());
            sc.setProductName(ci.getProductName());
            sc.setQuantity(ci.getQuantity());
            sc.setPrice(ci.getPrice());
            sc.setProductImg(ci.getProductImg());
            sc.setTotalAmount(ci.getPrice() * ci.getQuantity());
            sc.setSellOrder(order);
            return sc;
        }).toList();

        order.setCartItems(items);
        order.setAmount(
                items.stream()
                        .mapToLong(i -> i.getPrice() * i.getQuantity())
                        .sum()
        );

        return ResponseEntity.ok(
                orderRepo.save(order).getSellOrderDto()
        );
    }

    // ================= GET ALL SELL ORDERS =================
    @GetMapping("/sell-orders")
    public List<SellOrderDto> getAll() {
        return orderRepo.findAll()
                .stream()
                .map(SellOrder::getSellOrderDto)
                .toList();
    }

    // ================= SELL ORDER DETAILS =================
    @GetMapping("/sell-order/details/{id}")
    public ResponseEntity<SellOrderDto> details(@PathVariable Long id) {
        return orderRepo.findById(id)
                .map(o -> ResponseEntity.ok(o.getSellOrderDto()))
                .orElse(ResponseEntity.notFound().build());
    }
}
