package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.User;

@Controller
public class UserController {
	@InitBinder("user")
    public void customizeBinding (WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Date.class, "dateOfBirth",
                                    new CustomDateEditor(dateFormatter, true));
    }
	@RequestMapping(value = "/showUser", method = RequestMethod.GET)
	public String showForm(User user) {
		return "userForm";
	}

	@RequestMapping(value = "/submitUser", method = RequestMethod.POST)
	public String checkUserInfo(@Valid @ModelAttribute("user")User user, BindingResult bindingResult,HttpSession session) {
		String result = "";
		System.out.println(user.getDateOfBirth());
		session.setAttribute("uname", user.getName());
		if (bindingResult.hasErrors()) {
			result = "userForm";
		} else {
			result = "success";
		}
		return result;
	}
}