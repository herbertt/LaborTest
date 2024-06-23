package com.text2sql.llm.labor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@Column(name = "product_id")
	private int productId;
	
	@Column(name= "product_name")
	private String productName;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	@Column(name = "units_in_stock")
	private int unitsInStock;
	
	@OneToMany(mappedBy = "product")
	private List<OrderDetail> orderDetails;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;
}
