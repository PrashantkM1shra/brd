package com.nucleus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nucleus.dao.UserCustomerActionDaoInterface;
import com.nucleus.dto.CustomerDto;

@Service
@Transactional
public class UserCustomerActionService implements UserCustomerActionServiceInterface{
	
	@Autowired
	UserCustomerActionDaoInterface userCustomerActionDao;
	
	@Override
	public boolean saveCustomer(CustomerDto customer) {
		
		return userCustomerActionDao.saveCustomer(customer);
		
	}

	@Override
	public boolean deleteCustomer(int customerCode) {
		
		System.out.println("Inside Service method");
		return userCustomerActionDao.deleteCustomer(customerCode);
		
	}

	@Override
	public boolean updateCustomer(CustomerDto customer) {
		
		 return userCustomerActionDao.updateCustomer(customer);
	}

	@Override
	public CustomerDto getCustomer(int customerCode) {
		
		return userCustomerActionDao.getCustomer(customerCode);
	}

	@Override
	public List<CustomerDto> getAllCustomer() {
		
		return userCustomerActionDao.getAllCustomer();
	}

}
