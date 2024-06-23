package com.text2sql.llm.labor.controller;

import com.text2sql.llm.labor.business.abstracts.OrderDetailService;
import com.text2sql.llm.labor.business.responses.orderDetails.OrderDetailListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailsController {
	private OrderDetailService orderDetailService;

	public OrderDetailsController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
/*
	@PostMapping("/add")
	public Result add(@RequestBody CreateOrderDetailRequest createOrderDetailRequest) {
		return this.orderDetailService.add(createOrderDetailRequest);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteOrderDetailRequest deleteOrderDetailRequest) {
		return this.orderDetailService.delete(deleteOrderDetailRequest);
	}

    @GetMapping("/getbyid")
	public DataResult<OrderDetailGetResponse> getById(@RequestParam int orderId, int productId) {
		return this.orderDetailService.getById(orderId, productId);
	}
*/
	@GetMapping("/getall")
	public DataResult<List<OrderDetailListResponse>> getAll(){
		return this.orderDetailService.getAll();
	}
	
}
