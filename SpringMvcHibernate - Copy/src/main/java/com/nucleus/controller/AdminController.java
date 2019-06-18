package com.nucleus.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nucleus.dto.CustomerDto;
import com.nucleus.dto.UserDto;
import com.nucleus.service.AdminUserActionServiceInterface;

@Controller
public class AdminController {
	
	@Autowired
	AdminUserActionServiceInterface adminUserActionService;
	
	@RequestMapping(value="/saveUser", method=RequestMethod.GET)
	public String saveCustomer1(@ModelAttribute("user") UserDto user){
		
		return "addUser";
	}
	
	//Method to open add User page
		@RequestMapping(value="/saveUserData", method=RequestMethod.POST)
		public String saveUserDb(@Valid@ModelAttribute("user") UserDto user,Model model,BindingResult errors){
		
			if(errors.hasErrors()){
				return "addUser";
			}
			
			boolean count = adminUserActionService.addUser(user) ;
			if (count == true) {
				model.addAttribute("message","User Added");
			} else {
				model.addAttribute("message","User record not Added");
			}
			return "addUser";
		}
		
		//----------Update------------------
		
		@RequestMapping(value="/modifyUser", method=RequestMethod.GET)
		public String updateCustomerId(){
			
			return "updateUser";
		}
		
		@RequestMapping(value="/updateUser", method=RequestMethod.POST)
		public String updateCustomer(@Valid@ModelAttribute("user") UserDto user,Model model,BindingResult errors){
			
			if (errors.hasErrors()) {
				return "adminUpdateUser";
			}
			
			boolean result =adminUserActionService.updateUser(user);
			if (result == true) {
				model.addAttribute("message","User record Updated");
			} else {
				model.addAttribute("message","User record not Updated");
			}
			return "adminUpdateUser";
		}
		
		@RequestMapping(value="/userUpdate")
		public String viewCustomer(@RequestParam("userId") int userId,Model model)
		{
			UserDto user=adminUserActionService.getUser(userId);
			if(user==null){
				model.addAttribute("message","User doesn't exist");
				return "updateUser";
			}
			model.addAttribute("user",user);
			return "adminUpdateUser";
		}

}
