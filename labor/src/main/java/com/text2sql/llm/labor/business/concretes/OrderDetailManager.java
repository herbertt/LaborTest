package com.text2sql.llm.labor.business.concretes;

import com.text2sql.llm.labor.business.abstracts.OrderDetailService;
import com.text2sql.llm.labor.business.responses.orderDetails.OrderDetailGetResponse;
import com.text2sql.llm.labor.business.responses.orderDetails.OrderDetailListResponse;
import com.text2sql.llm.labor.entities.OrderDetail;
import com.text2sql.llm.labor.repository.OrderDetailRepository;
import com.text2sql.llm.labor.utils.mapping.ModelMapperService;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.SuccessDataResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class OrderDetailManager implements OrderDetailService {
	private OrderDetailRepository orderDetailRepository;
	private ModelMapperService modelMapperService;
	
	public OrderDetailManager(OrderDetailRepository orderDetailRepository, ModelMapperService modelMapperService) {
		this.orderDetailRepository = orderDetailRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<OrderDetailListResponse>> getAll() {
		List<OrderDetail> result = this.orderDetailRepository.findAll();
		List<OrderDetailListResponse> responses = result.stream().map(orderDetails -> this.modelMapperService.forResponse()
				.map(orderDetails, OrderDetailListResponse.class)).collect(Collectors.toList());
	
		return new SuccessDataResult<List<OrderDetailListResponse>>(responses);
	}

}
