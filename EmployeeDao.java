package com.dao;

import java.util.List;

import com.bean.Employee;

public interface EmployeeDao {
	List<Employee> fetchEmployees();

	void addEmployee(Employee emp);

	Employee getEmployee(int empId);

	void updateEmployee(Employee emp);

	void deleteEmployee(int empId);
}
