package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
//-->jsp(login object->null)->enter->
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Login;

@Controller
public class LoginController {


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(@ModelAttribute("login") Login login) {
		ModelAndView mview = new ModelAndView("login");
		mview.addObject("login", new Login());

		return mview;
	}

	@RequestMapping(value = "/loginValidate", method = RequestMethod.POST)

	public ModelAndView loginProcess(@ModelAttribute("login") Login login) {
		ModelAndView mav = null;

	
		if (login.getUsername().equals("admin")&&login.getPassword().equals("admin@123")) {
			mav = new ModelAndView("welcome");
			String username = login.getUsername();
			mav.addObject("uname", username);

		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}

		return mav;
	}
	}
