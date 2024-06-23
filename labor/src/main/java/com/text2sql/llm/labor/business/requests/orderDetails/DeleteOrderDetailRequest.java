package com.text2sql.llm.labor.business.requests.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteOrderDetailRequest {
	private int orderId;
	private int productId;
}
