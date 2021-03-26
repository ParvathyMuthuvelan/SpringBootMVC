package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@ModelAttribute("emp")
	public Employee getEmployee()
	{
		return new Employee();
	}

	
	@RequestMapping("/getEmployees")
	public  String getEmployees(ModelMap model)
	{
		List<Employee> empList=employeeService.fetchEmployees();
		
		model.addAttribute("emplist",empList);
		return "employeesListDisplay";
		
	}
	
	@RequestMapping("/findEmployee")
	public ModelAndView findEmployee()
	{
		return new ModelAndView("searchEmployee","command",new Employee());
		
	}
	@RequestMapping(value="/createEmployee",method=RequestMethod.GET)
	public  String createEmployeePage(@ModelAttribute("emp") Employee emp)
	{
		//ModelAndView mv=new ModelAndView("employeeForm","command",new Employee());
		//return mv;
		return "employeeForm";
		}
		
	@PostMapping(value="/addEmployee")
	public  String addEmployee(@ModelAttribute("emp")Employee emp)
	{
		employeeService.addEmployee(emp);
		return "redirect:/employee/getEmployees";
		}
	//showEditEmployee/1
	@RequestMapping("/showEditEmployee/{employeeId}")
	public String showEditEmployeePage(Model model,@PathVariable("employeeId")int empId)
    {
		System.out.println(empId);
        Employee employee=employeeService.getEmployee(empId);
       
      model.addAttribute("command", employee);
        return "editEmployee";
    }
	 @PostMapping(value = "/update")
	    public String updateEmployee(@ModelAttribute("emp")Employee emp)
	    {
	    	
	    employeeService.updateEmployee(emp);
	        return "redirect:/employee/getEmployees";
	    }
	 @RequestMapping(value = "/deleteEmployee/{employeeId}")
	    public String deleteEmployee(@PathVariable("employeeId")  int empId)
	    {
	    	
	    	employeeService.deleteEmployee(empId);
	        return "redirect:/employee/getEmployees";
	    }
	 
}






