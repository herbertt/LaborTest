package com.text2sql.llm.labor.business.requests.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderDetailRequest {
	private int orderId;
	private int productId;
	private double unitPrice;
	private int quantity;
	private double discount;
}
