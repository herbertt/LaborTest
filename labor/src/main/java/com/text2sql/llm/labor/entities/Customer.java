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
@Table(name = "customers")
public class Customer {

		@Id
		@Column(name = "id")
		private int customerId;

		@Column(name = "company", length = 50)
		private String company;

		@Column(name = "last_name", length = 50)
		private String lastName;

		@Column(name = "first_name", length = 50)
		private String firstName;

		@Column(name = "email_address", length = 50)
		private String emailAddress;

		@Column(name = "job_title", length = 50)
		private String jobTitle;

		@Column(name = "business_phone", length = 25)
		private String businessPhone;

		@Column(name = "home_phone", length = 25)
		private String homePhone;

		@Column(name = "mobile_phone", length = 25)
		private String mobilePhone;

		@Column(name = "fax_number", length = 25)
		private String faxNumber;

		@Column(name = "address", columnDefinition = "LONGTEXT")
		private String address;

		@Column(name = "city", length = 50)
		private String city;

		@Column(name = "state_province", length = 50)
		private String stateProvince;

		@Column(name = "zip_postal_code", length = 15)
		private String zipPostalCode;

		@Column(name = "country_region", length = 50)
		private String countryRegion;

		@Column(name = "web_page", columnDefinition = "LONGTEXT")
		private String webPage;

		@Column(name = "notes", columnDefinition = "LONGTEXT")
		private String notes;

		@Column(name = "attachments", columnDefinition = "LONGBLOB")
		private byte[] attachments;

}
