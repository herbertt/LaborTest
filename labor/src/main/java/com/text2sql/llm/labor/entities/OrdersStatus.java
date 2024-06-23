package com.text2sql.llm.labor.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders_status")
public class OrdersStatus {

    @Id
    @Column(name = "id")
    private Byte id;

    @Column(name = "status_name", length = 50, nullable = false)
    private String statusName;
}
