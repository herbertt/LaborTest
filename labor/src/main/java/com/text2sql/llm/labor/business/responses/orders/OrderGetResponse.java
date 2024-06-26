package com.text2sql.llm.labor.business.responses.orders;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderGetResponse {
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private String customerId;
	private String customerCompanyName;
	private int employeeId;
	private String fullName;
}
