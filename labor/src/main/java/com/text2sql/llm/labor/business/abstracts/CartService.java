package com.text2sql.llm.labor.business.abstracts;

import com.text2sql.llm.labor.business.requests.cart.CreateCartRequest;
import com.text2sql.llm.labor.business.requests.cart.DeleteCartRequest;
import com.text2sql.llm.labor.business.requests.cart.UpdateCartRequest;
import com.text2sql.llm.labor.business.responses.carts.CartListResponse;
import com.text2sql.llm.labor.business.responses.carts.CartReadResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;

import java.util.List;


public interface CartService {
    Result add(CreateCartRequest createCartRequest);
    Result update(UpdateCartRequest updateCartRequest);
    Result delete(DeleteCartRequest deleteCartRequest);
    DataResult<CartReadResponse> getById(int cartId);
    DataResult<List<CartListResponse>> getAll();
}
