package com.text2sql.llm.labor.business.abstracts;

import com.text2sql.llm.labor.business.requests.cartItems.CreateCartItemsRequest;
import com.text2sql.llm.labor.business.requests.cartItems.DeleteCartItemsRequest;
import com.text2sql.llm.labor.business.requests.cartItems.UpdateCartItemsRequest;
import com.text2sql.llm.labor.business.responses.cartItems.CartItemsListResponse;
import com.text2sql.llm.labor.business.responses.cartItems.CartItemsReadResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;

import java.util.List;


public interface CartItemService {
    Result add(CreateCartItemsRequest createCartItemRequest);
    Result update(UpdateCartItemsRequest updateCartItemsRequest);
    Result delete(DeleteCartItemsRequest deleteCartItemsRequest);
    DataResult<CartItemsReadResponse> getById(int cartItemId);
    DataResult<List<CartItemsListResponse>> getAll();
}
