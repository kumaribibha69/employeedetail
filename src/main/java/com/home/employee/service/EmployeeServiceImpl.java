package com.home.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.employee.dao.EmployeeDao;
import com.home.employee.dto.EmployeeDTO;
import com.home.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDTO> listEmployee() {
		List<Employee> employees = employeeDao.listEmployee();
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		for (Employee employee : employees) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setId(employee.getId());
			dto.setName(employee.getName());
			dto.setCity(employee.getCity());
			employeeDTOs.add(dto);
		}
		return employeeDTOs;
	}

	@Override
	@Transactional
	public void addEmployee(EmployeeDTO p) {
		Employee employee = new Employee();
		employee.setName(p.getName());
		employee.setCity(p.getCity());
		employeeDao.addEmployee(employee);

	}

	@Override
	@Transactional
	public void updateEmployee(EmployeeDTO p) {
		Employee employee = new Employee();
		employee.setName(p.getName());
		employee.setCity(p.getCity());
		employee.setId(p.getId());
		employeeDao.updateEmployee(employee);
	}

	@Override
	@Transactional
	public void removeEmployee(int id) {
		employeeDao.removeEmployee(id);
	}

	@Override
	@Transactional(readOnly = true)
	public EmployeeDTO getEmployeeById(int id) {
		Employee employee = employeeDao.getEmployeeById(id);
		EmployeeDTO dto = new EmployeeDTO();
		dto.setCity(employee.getCity());
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		return dto;
	}

}
