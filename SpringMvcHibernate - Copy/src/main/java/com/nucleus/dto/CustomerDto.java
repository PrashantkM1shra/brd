package com.nucleus.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="CustomerData04192019")
@SequenceGenerator(name="customerDataSeq",sequenceName="customerDataSeq")
public class CustomerDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="customerDataSeq")
	private int customerCode;
	
	@Pattern(regexp = "[a-z A-Z0-9]*", message="Can enter Alpha-numeric data")
	@NotNull(message="Please enter Customer Name")
	@Length(min=1, max=30, message="Should not be more than 30 characters")
	private String customerName;
	
	@NotNull(message="Please enter Customer Address")
	@Length(min=1, max=100, message="Should not be more than 100 characters")
	private String customerAddress;
	
	@Pattern(regexp = "[0-9]*",  message="Can enter numeric data")
	@NotNull(message="Please enter Customer PinCode")
	@Length(min=6 , max=6, message="Pincode should be of 6 digits")
	private String customerPinCode;
	
	@Length(min=6, max=100, message="Should not be more than 100 characters")
	@Email(message="Invalid email")
	@NotNull(message="Please enter Customer Email")
	private String customerEmail;
	
	@Pattern(regexp = "[0-9]*", message="Should be digits only")
	@Length(min=5, max=20, message="should not be more than 20 digits")
	private String customerNumber;
	
	@NotNull(message="Registration Date is a mandatory field")
	private String registrationDate;
	
	@NotNull(message="Created By is a mandatory field")
	private String createdBy;
	private String modifiedDate;
	
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerPinCode() {
		return customerPinCode;
	}
	public void setCustomerPinCode(String customerPinCode) {
		this.customerPinCode = customerPinCode;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	

}
