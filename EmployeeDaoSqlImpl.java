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
		String sql = "INSERT INTO employees(firstname,lastname,email) values (?,?,?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getFirstName(), emp.getLastName(),emp.getEmail()
		});
		
	}

	@Override
	public Employee getEmployee(int empId) {
		Employee emp=new Employee();
		String sql = "SELECT * FROM employees WHERE employeeId = ?";
		emp = getJdbcTemplate().queryForObject(sql, new Object[] { empId }, new EmployeeMapper());
		return emp;
	}

	@Override
	public void updateEmployee(Employee emp) {
		String sql = "update employees set firstname=? ,lastname=?,email=? where employeeId=?" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getFirstName(), emp.getLastName(),emp.getEmail(),emp.getEmployeeId()
		});
		
	}

	@Override
	public void deleteEmployee(int empId) {
		String sql = "delete from employees where employeeId=?" ;
		getJdbcTemplate().update(sql, new Object[]{	empId	});
		
	}

}
