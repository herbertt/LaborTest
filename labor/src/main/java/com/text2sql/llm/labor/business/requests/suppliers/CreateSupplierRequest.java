package com.text2sql.llm.labor.business.requests.suppliers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupplierRequest {
	private int supplierId;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;

}
