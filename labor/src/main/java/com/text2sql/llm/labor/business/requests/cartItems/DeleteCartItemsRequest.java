package com.text2sql.llm.labor.business.requests.cartItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCartItemsRequest {
    private int cartItemId;
}
