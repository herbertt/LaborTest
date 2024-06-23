package com.text2sql.llm.labor.business.abstracts;

import com.text2sql.llm.labor.business.requests.orders.CreateOrderRequest;
import com.text2sql.llm.labor.business.requests.orders.DeleteOrderRequest;
import com.text2sql.llm.labor.business.requests.orders.UpdateOrderRequest;
import com.text2sql.llm.labor.business.responses.orders.OrderGetResponse;
import com.text2sql.llm.labor.business.responses.orders.OrderListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;

import java.util.List;


public interface OrderService {
	Result add(CreateOrderRequest createOrderRequest);
	Result delete(DeleteOrderRequest deleteOrderRequest);
	Result update(UpdateOrderRequest updateOrderRequest);
	DataResult<OrderGetResponse> getById(int id);
	DataResult<List<OrderListResponse>> getAll();
}
