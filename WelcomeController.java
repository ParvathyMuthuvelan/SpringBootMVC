package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import com.bean.LoginBean;

@Controller
public class WelcomeController {
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showMessage(@SessionAttribute("login") LoginBean log,ModelMap map,HttpSession session,SessionStatus status) {
		//map.addAttribute("msg", "Welcome to Spring Boot");
		System.out.println("username in welcome"+log.getUserName());
		map.addAttribute("uname", log.getUserName());
		session.invalidate();
		status.setComplete();
		return "welcome";
	}
}
