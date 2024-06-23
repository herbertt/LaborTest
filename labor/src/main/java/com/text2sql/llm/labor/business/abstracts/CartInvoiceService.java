package com.text2sql.llm.labor.business.abstracts;

import com.text2sql.llm.labor.business.requests.cartInvoices.CreateCartInvoiceRequest;
import com.text2sql.llm.labor.business.requests.cartInvoices.DeleteCartInvoiceRequest;
import com.text2sql.llm.labor.business.requests.cartInvoices.UpdateCartInvoiceRequest;
import com.text2sql.llm.labor.business.responses.cartInvoices.CartInvoiceListResponse;
import com.text2sql.llm.labor.business.responses.cartInvoices.CartInvoiceReadResponse;
import com.text2sql.llm.labor.utils.results.DataResult;
import com.text2sql.llm.labor.utils.results.Result;

import java.util.List;

public interface CartInvoiceService {
    Result add(CreateCartInvoiceRequest createCartInvoiceRequest);
    Result update(UpdateCartInvoiceRequest updateCartInvoiceRequest);
    Result delete(DeleteCartInvoiceRequest deleteCartInvoiceRequest);
    DataResult<CartInvoiceReadResponse> getById(int cartInvoiceId);
    DataResult<List<CartInvoiceListResponse>> getAll();
}
