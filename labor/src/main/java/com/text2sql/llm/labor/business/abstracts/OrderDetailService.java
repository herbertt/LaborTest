package com.text2sql.llm.labor.business.abstracts;

import com.text2sql.llm.labor.business.responses.orderDetails.OrderDetailListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;

import java.util.List;


public interface OrderDetailService {
//	Result add(CreateOrderDetailRequest createOrderDetailRequest);
//	Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest);
//	Result update(UpdateOrderDetailRequest updateOrderDetailRequest);
//	DataResult<OrderDetailGetResponse> getById(int orderId, int productId);
	DataResult<List<OrderDetailListResponse>> getAll();
}
