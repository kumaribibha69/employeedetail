package com.home.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.employee.dto.EmployeeDTO;
import com.home.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("employee", new EmployeeDTO());
		model.addAttribute("listEmployee", this.employeeService.listEmployee());
		return "employee";
	}

	// For add and update person both
	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("employee") EmployeeDTO employee) {
		if (employee.getId() == null) {
			this.employeeService.addEmployee(employee);
		} else {
			this.employeeService.updateEmployee(employee);
		}
		return "redirect:/employee";
	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {
		this.employeeService.removeEmployee(id);
		return "redirect:/employee";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		model.addAttribute("listEmployee", this.employeeService.listEmployee());
		return "employee";
	}

}
