package com.nucleus.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nucleus.dto.CustomerDto;
import com.nucleus.service.UserCustomerActionServiceInterface;

@Controller
public class UserController {
	
	@Autowired
	UserCustomerActionServiceInterface userCustomerActionService;
	
	// Get System Date
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		Date date = new Date();
		String sysdate = dateFormat.format(date);
	
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public String saveCustomer1(@ModelAttribute("customer") CustomerDto customer){
		
		return "userAddCustomer";
	}

	//Method to open add User page
	@RequestMapping(value="/saveCustomer", method=RequestMethod.POST)
	public String saveCustomer2(@Valid@ModelAttribute("customer") CustomerDto customer, BindingResult errors, Model model, Principal principal){
		
		if(errors.hasErrors()){
			return ("userAddCustomer");
		}
		String userName = principal.getName();
		customer.setRegistrationDate(sysdate);
		customer.setCreatedBy(userName);
		boolean result= userCustomerActionService.saveCustomer(customer);
		
		if(result==true){
			model.addAttribute("message", "Customer Data Save in Database");
		}
		else{
			model.addAttribute("message", "Customer Data not Save in Database");
		}
		return "userAddCustomer";
				
	}
	
	//-----------Delete-----------------
	
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public String deleteCustomer(){
		
		return "userDeleteCustomer";
	}
	
	@RequestMapping(value="/customerDelete",method=RequestMethod.POST)
	public String deleteCustomerId(@RequestParam("customerCode") int customerCode,Model model)
	{
		System.out.println("Inside delete customer");
		
		boolean result= userCustomerActionService.deleteCustomer(customerCode);
		
		if(result==true){
			model.addAttribute("message", "Customer Deleted from Database");
		}
		else{
			model.addAttribute("message", "Customer Doesn't exist!");
		}
		
		return "userDeleteCustomer";
	}
	
	//----------Update------------------
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String updateCustomerId(){
		
		return "updateCustomer";
	}
	
	@RequestMapping(value="/updateCustomer", method=RequestMethod.POST)
	public String updateCustomer(@Valid@ModelAttribute("customer") CustomerDto customer,Model model,BindingResult errors){
		
		if (errors.hasErrors()) {
			return "userUpdateCustomer";
		}
		customer.setModifiedDate(sysdate);
		boolean result =userCustomerActionService.updateCustomer(customer);
		if (result == true) {
			model.addAttribute("message","Customer record Updated");
		} else {
			model.addAttribute("message","Customer record not Updated");
		}
		return "userUpdateCustomer";
	}
	
	@RequestMapping(value="/customerUpdate")
	public String viewCustomer(@RequestParam("customerCode") int customerCode,Model model)
	{
		CustomerDto customer=userCustomerActionService.getCustomer(customerCode);
		if(customer==null){
			model.addAttribute("message","Customer doesn't exist");
			return "updateCustomer";
		}
		model.addAttribute("customer",customer);
		return "userUpdateCustomer";
	}
	
	//---------View-------------------
	
	@RequestMapping(value="/viewOne", method=RequestMethod.GET)
	public String viewCustomerId(){
		
		return "viewById";
	}
	
	@RequestMapping(value="/viewACustomer")
	public String viewACustomer(@RequestParam("customerCode") int customerCode,Model model)
	{
		CustomerDto customer=userCustomerActionService.getCustomer(customerCode);
		if(customer==null){
			model.addAttribute("message","Customer doesn't exist");
			return "viewById";
		}
		
		model.addAttribute("customer",customer);
		return "viewById";
	}
	
	//---------View All-------------------
	
	@RequestMapping(value="/viewAll", method=RequestMethod.GET)
	public String viewAllCustomer(Model model){
		
		List<CustomerDto> customerData=userCustomerActionService.getAllCustomer();
		model.addAttribute("customerData",customerData);
		return "viewAllResult";
	}
	
}
