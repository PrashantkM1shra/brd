package com.nucleus.dao;

import java.util.List;

import com.nucleus.dto.CustomerDto;

public interface UserCustomerActionDaoInterface {
	
	public boolean saveCustomer(CustomerDto customer);

	public boolean deleteCustomer(int customerCode);

	public boolean updateCustomer(CustomerDto customer);
	
	public CustomerDto getCustomer(int customerCode);
	
	public List<CustomerDto> getAllCustomer();
}
