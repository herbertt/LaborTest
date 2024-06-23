package com.text2sql.llm.labor.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailId implements Serializable{
    private static final long serialVersionUID = 1L;

    private int orderId;
    private int productId;

}
