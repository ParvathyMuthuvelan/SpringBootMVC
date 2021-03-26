package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bean.LoginBean;
import com.service.LoginService;



@Controller
@SessionAttributes("login")
public class LoginController {
	
	@ModelAttribute("login")
	public LoginBean loginBean()
	{
	    return new LoginBean();
	}
	
	@Autowired
	private LoginService service;

    @RequestMapping(value="/showLogin", method=RequestMethod.GET)
	public String showLoginpage(@ModelAttribute("login") LoginBean log) {
	    
			return "loginPage"; //viewname

	}


	@RequestMapping(value="/loginValidate", method=RequestMethod.POST)
	public String checkLoginDetails(ModelMap map,@ModelAttribute("login") LoginBean log, 
			BindingResult result,RedirectAttributes attributes) {
		
	    if(service.validate(log))
	    {
	    	System.out.println(log.getUserName());
	    	map.addAttribute("msg", log.getUserName());
	        return "success";
	    	
	    }
	    else
	    {
	       // return "invalid";
	    	attributes.addFlashAttribute("msg", "Invalid credentials..!Try again");
	    	return "redirect:showLogin"; //call the requestmapping login
	    }

	}
	

}
