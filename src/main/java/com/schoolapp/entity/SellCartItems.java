package com.schoolapp.entity;

import com.schoolapp.dao.SellCartItemsDto;

//import com.Crmemp.dto.request.SellCartItemsDto;

//import com.employeemanagement.dto.request.SellCartItemsDto;
import jakarta.persistence.*;

@Entity
@Table(name = "sell_cart_items")
public class SellCartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private String productName;
    private Long quantity;
    private Long price;

    @Lob
    private String productImg;

    private Long totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private SellOrder sellOrder;

    public SellCartItemsDto toDto() {
        SellCartItemsDto dto = new SellCartItemsDto();
        dto.setOrderId(sellOrder != null ? sellOrder.getId() : null);
        dto.setProductId(productId);
        dto.setProductName(productName);
        dto.setQuantity(quantity);
        dto.setPrice(price);
        dto.setProductImg(productImg);
        dto.setTotalAmount(totalAmount);
        return dto;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public SellOrder getSellOrder() {
		return sellOrder;
	}

	public void setSellOrder(SellOrder sellOrder) {
		this.sellOrder = sellOrder;
	}

    // 👉 getters & setters SAME
}
