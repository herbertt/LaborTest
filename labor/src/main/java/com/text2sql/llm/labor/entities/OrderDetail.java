package com.text2sql.llm.labor.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="order_details")
@IdClass(OrderDetailId.class)
public class OrderDetail{
	
	@Id
	@Column(name = "id")
	private int orderId;
	
	@Id
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name ="discount")
	private double discount;

	@ManyToOne
	@JoinColumn(name="orderId", insertable = false, updatable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="product_id", insertable = false, updatable = false)
	private Product product;
	
}
