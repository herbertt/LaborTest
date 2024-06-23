package com.text2sql.llm.labor.repository;

import com.text2sql.llm.labor.entities.OrderDetail;
import com.text2sql.llm.labor.entities.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
//	@Query("Select od From OrderDetail od where order_id = :orderId and product_id = :productId")
//	OrderDetail getOrderDetailWithOrderIdAndProductId(@Param("orderId") int orderId, @Param("productId") int productId);
	OrderDetail getByOrder_OrderIdAndProduct_ProductId( int orderId,int productId);

	//@Transactional
		//@Modifying
		//@Query("Delete From OrderDetail where order_id = :orderId and product_id = :productId")
	//void deleteOrderDetailWithOrderIdAndProductId(@Param("orderId") int orderId, @Param("productId") int productId);
}
