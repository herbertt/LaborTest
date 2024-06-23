package com.text2sql.llm.labor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="suppliers")
public class Supplier {
	@Id
	@Column(name = "supplier_id")
	private int supplierId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "contact_title")
	private String contactTitle;
	
	@Column(name = "address")
	private String address;
	
	@OneToMany(mappedBy = "supplier")
	private List<Product> products;
	
}
