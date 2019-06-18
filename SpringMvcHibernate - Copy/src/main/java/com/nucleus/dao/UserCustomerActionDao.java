package com.nucleus.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nucleus.dto.CustomerDto;

@Repository
public class UserCustomerActionDao implements UserCustomerActionDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveCustomer(CustomerDto customer) {
		try {
			sessionFactory.getCurrentSession().persist(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteCustomer(int customerCode) {
		try {
			System.out.println("Inside dao");
			CustomerDto customer = this.getCustomerDto(customerCode);
			sessionFactory.getCurrentSession().delete(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private CustomerDto getCustomerDto(int customerCode) {
		Session session = sessionFactory.openSession();
		CustomerDto customer = (CustomerDto) session.get(CustomerDto.class, customerCode);
		session.close();
		return customer;
	}

	@Override
	public boolean updateCustomer(CustomerDto customer) {
		try {
			sessionFactory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public CustomerDto getCustomer(int customerCode) {
		Session session = sessionFactory.openSession();
		CustomerDto customer = (CustomerDto) session.get(CustomerDto.class, customerCode);
		session.close();
		return customer;
	}

	@Override
	public List<CustomerDto> getAllCustomer() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CustomerDto");
		List<CustomerDto> customerData = query.list();
		session.close();
		return customerData;
	}

}
