package com.pack.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.controller.EmployeeController;
import com.pack.dao.EmployeeDao;
import com.pack.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private static Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeDao employeedao;

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		log.info("Inside saveEmployee()");
		employeedao.saveEmployee(employee);

	}

	@Override
	public List<Employee> fetchEmployee() {
		// TODO Auto-generated method stub
		log.info("Inside fetchEmployee()");
		List<Employee> empList = employeedao.fetchEmployee();
		return empList;
	}

	public Employee fetchEmployeeById(Integer empId) {
		// TODO Auto-generated method stub
		log.info("Inside fetchEmployeeById()");
		Employee employee = employeedao.fetchEmployeeById(empId);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		log.info("Inside updateEmployee()");
		employeedao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Integer eid) {
		// TODO Auto-generated method stub
		log.info("Inside deleteEmployee()");
		employeedao.deleteEmployee(eid);
	}

}
