package com.home.employee.service;

import java.util.List;

import com.home.employee.dto.EmployeeDTO;

public interface EmployeeService {

	List<EmployeeDTO> listEmployee();

	void addEmployee(EmployeeDTO p);

	void updateEmployee(EmployeeDTO p);

	void removeEmployee(int id);

	EmployeeDTO getEmployeeById(int id);

}
