package com.text2sql.llm.labor.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer orderId;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	@Column(name = "shipped_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date shippedDate;

	@ManyToOne
	@JoinColumn(name = "shipper_id")
	private Shipper shipper;

	@Column(name = "ship_name", length = 50)
	private String shipName;

	@Column(name = "ship_address", columnDefinition = "LONGTEXT")
	private String shipAddress;

	@Column(name = "ship_city", length = 50)
	private String shipCity;

	@Column(name = "ship_state_province", length = 50)
	private String shipStateProvince;

	@Column(name = "ship_zip_postal_code", length = 50)
	private String shipZipPostalCode;

	@Column(name = "ship_country_region", length = 50)
	private String shipCountryRegion;

	@Column(name = "shipping_fee", precision = 19, scale = 4, columnDefinition = "decimal(19,4) default '0.0000'")
	private BigDecimal shippingFee;

	@Column(name = "taxes", precision = 19, scale = 4, columnDefinition = "decimal(19,4) default '0.0000'")
	private BigDecimal taxes;

	@Column(name = "payment_type", length = 50)
	private String paymentType;

	@Column(name = "paid_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date paidDate;

	@Column(name = "notes", columnDefinition = "LONGTEXT")
	private String notes;

	@Column(name = "tax_rate", columnDefinition = "double default '0'")
	private Double taxRate;

	@ManyToOne
	@JoinColumn(name = "tax_status_id")
	private OrdersTaxStatus taxStatus;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private OrdersStatus status;

}
