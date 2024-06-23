package com.text2sql.llm.labor.controller;

import com.text2sql.llm.labor.business.abstracts.OrderService;
import com.text2sql.llm.labor.business.requests.orders.CreateOrderRequest;
import com.text2sql.llm.labor.business.requests.orders.DeleteOrderRequest;
import com.text2sql.llm.labor.business.requests.orders.UpdateOrderRequest;
import com.text2sql.llm.labor.business.responses.orders.OrderGetResponse;
import com.text2sql.llm.labor.business.responses.orders.OrderListResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	private OrderService orderService;

	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<OrderListResponse>> getAll(){
		return this.orderService.getAll();
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody CreateOrderRequest createOrderRequest){
        return this.orderService.add(createOrderRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteOrderRequest deleteOrderRequest){
        return this.orderService.delete(deleteOrderRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateOrderRequest updateOrderRequest){
        return this.orderService.update(updateOrderRequest);
    }


    @GetMapping("/getbyid")
    public DataResult<OrderGetResponse> getById(@RequestParam int id){
        return this.orderService.getById(id);
    }
}
