package com.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.bean.Employee;
@Repository
public class EmployeeDaoSqlImpl extends JdbcDaoSupport implements EmployeeDao{
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	@Override
	public List<Employee> fetchEmployees() {
		String sql = "SELECT * FROM employees";
		List<Employee> empList = getJdbcTemplate().query(sql, new EmployeeMapper());
		return empList;
	
		}
		
	

	@Override
	public void addEmployee(Employee emp) {
		String sql = "INSERT INTO employee " +
				"(empId, empName) VALUES (?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getEmployeeId(), emp.getFirstName()
		});
		
	}

	@Override
	public Employee getEmployee(int empId) {
		Employee emp=new Employee();
		String sql = "SELECT * FROM employee WHERE empId = ?";
		return emp;
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		
	}

}
