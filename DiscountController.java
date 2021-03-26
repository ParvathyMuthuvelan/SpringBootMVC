package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Productt;
import com.service.DiscountService;

@Controller
public class DiscountController {
	@Autowired
	private DiscountService discountService;
//	@ModelAttribute("product")
//	public Productt getProduct()
//	{
//		return new Productt();
//	}
	@RequestMapping(value="/getDiscountedPrice",method=RequestMethod.GET)
	public String discountPage(@ModelAttribute("product") Productt product)
	{
		
		return "calculateddiscount";
	}
	@ModelAttribute("productTypeList")
	public List<String> populateProductType()
	{
		List<String> productList=new ArrayList<>();
		productList.add("Electronic");
		productList.add("Apparels");
		productList.add("Toys");
		return productList;
	}
	@RequestMapping(value = "/calculateDiscountedPrice", method = RequestMethod.POST)
	public String calculateTotalCost(@Valid @ModelAttribute("product") Productt product,
			BindingResult result,ModelMap model) {
		String res="";
		double discountPrice=0;
		if(result.hasErrors())
		{
			//System.out.println("validation errors");
			res="calculateddiscount";
		}
		else
		{
		discountPrice = discountService.calculatePrice(product);
		model.put("price", discountPrice);
			res="finalPrice";
		}
		return res;
	}
}
