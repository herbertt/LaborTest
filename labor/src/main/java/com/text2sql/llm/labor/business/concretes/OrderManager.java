package com.text2sql.llm.labor.business.concretes;

import com.text2sql.llm.labor.business.abstracts.OrderService;
import com.text2sql.llm.labor.business.requests.orders.CreateOrderRequest;
import com.text2sql.llm.labor.business.requests.orders.DeleteOrderRequest;
import com.text2sql.llm.labor.business.requests.orders.UpdateOrderRequest;
import com.text2sql.llm.labor.business.responses.orders.OrderGetResponse;
import com.text2sql.llm.labor.business.responses.orders.OrderListResponse;
import com.text2sql.llm.labor.entities.Order;
import com.text2sql.llm.labor.repository.OrderRepository;
import com.text2sql.llm.labor.utils.mapping.ModelMapperService;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;
import com.text2sql.llm.labor.utils.results.SuccessDataResult;
import com.text2sql.llm.labor.utils.results.SuccessResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderManager implements OrderService {
	private OrderRepository orderRepository;
	private ModelMapperService modelMapperService;

	public OrderManager(OrderRepository orderRepository, ModelMapperService modelMapperService) {
		this.orderRepository = orderRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<OrderListResponse>> getAll() {
		List<Order> result = this.orderRepository.findAll();
		List<OrderListResponse> responses = result.stream()
				.map(order -> this.modelMapperService.forResponse().map(order, OrderListResponse.class))
				.collect(Collectors.toList());

		for (int i = 0; i < responses.size(); i++) {
			responses.get(i).setFullName(
					result.get(i).getEmployee().getFirstName() + " " + result.get(i).getEmployee().getLastName());
		}
		return new SuccessDataResult<List<OrderListResponse>>(responses);
	}

	@Override
	public Result add(CreateOrderRequest createOrderRequest) {
		Order order = this.modelMapperService.forRequest().map(createOrderRequest, Order.class);
		this.orderRepository.save(order);
		return new SuccessResult("Added");
	}

	@Override
	public Result delete(DeleteOrderRequest deleteOrderRequest) {
		this.orderRepository.deleteById(deleteOrderRequest.getOrderId());
		return new SuccessResult("Deleted");
	}

	@Override
	public Result update(UpdateOrderRequest updateOrderRequest) {
		Order order = this.modelMapperService.forRequest().map(updateOrderRequest, Order.class);
		this.orderRepository.save(order);
		return new SuccessResult("Updated");

	}

	@Override
	public DataResult<OrderGetResponse> getById(int id) {
		Order order = this.orderRepository.findById(id).get();
		OrderGetResponse response = this.modelMapperService.forResponse().map(order, OrderGetResponse.class);
		return new SuccessDataResult<OrderGetResponse>(response);
	}

}
