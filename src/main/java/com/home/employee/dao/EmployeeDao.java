package com.home.employee.dao;

import java.util.List;

import com.home.employee.entity.Employee;

public interface EmployeeDao {

	public List<Employee> listEmployee();

	public void addEmployee(Employee employee);

	public void removeEmployee(Integer id);
	
	public Employee getEmployeeById(Integer id);

	public void updateEmployee(Employee employee);

}
