package com.pack.dao;

import java.util.List;

import com.pack.model.Employee;

public interface EmployeeDao {
	public void saveEmployee(Employee employee);
	public List<Employee> fetchEmployee();
	public Employee fetchEmployeeById(Integer empId);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer eid);
}
