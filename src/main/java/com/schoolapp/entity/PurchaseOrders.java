package com.schoolapp.entity;

//package com.Crmemp.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.schoolapp.dao.PurchaseOrderDto;
import com.schoolapp.enums.OrderStatus;

//import com.Crmemp.dto.request.PurchaseOrderDto;
//import com.employeemanagement.enums.OrderStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String orderDescription;
	private LocalDateTime date;
	private Long amount;
	private String address;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	private UUID trackingId;
	private String email;
	private String mobile;
	private String pincode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
	private List<PurchaseCartItems> cartItems;

	/* ===== DTO CONVERTER ===== */
	public PurchaseOrderDto getPurchaseOrderDto() {
		PurchaseOrderDto dto = new PurchaseOrderDto();
		dto.setId(id);
		dto.setOrderDescription(orderDescription);
		dto.setDate(date);
		dto.setAmount(amount);
		dto.setAddress(address);
		dto.setOrderStatus(orderStatus);
		dto.setTrackingId(trackingId);
		dto.setUserId(user != null ? user.getId() : null);
		dto.setUserName(user != null ? user.getUsername() : null);
		dto.setEmail(email);
		dto.setMobile(mobile);
		dto.setPincode(pincode);

		if (cartItems != null) {
			dto.setCartItems(cartItems.stream().map(PurchaseCartItems::toDto).collect(Collectors.toList()));
		}
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public UUID getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<PurchaseCartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<PurchaseCartItems> cartItems) {
		this.cartItems = cartItems;
	}

	// getters & setters (keep as is)
}

