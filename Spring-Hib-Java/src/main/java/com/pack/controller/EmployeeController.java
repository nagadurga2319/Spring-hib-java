package com.pack.controller;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.model.Employee;
import com.pack.service.EmployeeService;

@Controller
public class EmployeeController {
	private static Logger log = Logger.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String loadRegistrationForm(ModelMap map) {
		log.info("Request inside loadRegistration method");
		Employee employee = new Employee();
		map.addAttribute("empForm", employee);
		return "employeeRegister";
	}

	@RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
	public String saveEmployee(@Validated @ModelAttribute("empForm") Employee employee, BindingResult result,
			ModelMap map) {
		String viewPage;
		if (result.hasErrors()) {
			log.info("validation errors occured");
			viewPage = "employeeRegister";
		} else {
			log.info("invoking saveEmployee method");
			Random r = new Random();
			int empid = r.nextInt(99999) + 10000;
			employee.setId(empid);
			employeeService.saveEmployee(employee);
			List<Employee> empList = employeeService.fetchEmployee();
			map.addAttribute("employeeList", empList);
			viewPage = "EmployeeSuccess";
		}
		return viewPage;
	}

	@RequestMapping(value = "/fetchById/{empId}")
	public String fetchEmployeeById(@PathVariable("empId") Integer emplId, ModelMap map) {
		log.info("Fetching employee info by id");
		Employee employee = employeeService.fetchEmployeeById(emplId);
		map.addAttribute("editForm", employee);
		return "EmployeeUpdate";
	}

	@RequestMapping(value = "/editEmp", method = RequestMethod.POST)
	public String updateEmployee(@Validated @ModelAttribute("empForm") Employee employee, BindingResult result,
			ModelMap map) {
		String editViewPage;
		if (result.hasErrors()) {
			log.info("validations error occur");
			editViewPage = "EmployeeUpdate";
		} else {
			log.info("invoking method to update data");
			employeeService.updateEmployee(employee);
			List<Employee> empList = employeeService.fetchEmployee();
			map.addAttribute("employeeList", empList);
			editViewPage = "EmployeeSuccess";
		}
		return editViewPage;
	}

	@RequestMapping(value = "/delete/{empId}")
	public String deleteEmployee(@PathVariable("empId") Integer eid, ModelMap map) {
		log.info("Deleting employee based on employee id");
		employeeService.deleteEmployee(eid);
		return "redirect:/fetch";
	}

	@RequestMapping(value = "/fetch")
	public String fetchEmployee(ModelMap map) {
		List<Employee> empList = employeeService.fetchEmployee();
		map.addAttribute("employeeList", empList);
		return "EmployeeSuccess";
	}
}
