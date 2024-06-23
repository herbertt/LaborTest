package com.text2sql.llm.labor.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders_tax_status")
public class OrdersTaxStatus {

    @Id
    @Column(name = "id")
    private Byte id;

    @Column(name = "tax_status_name", length = 50, nullable = false)
    private String taxStatusName;
}
