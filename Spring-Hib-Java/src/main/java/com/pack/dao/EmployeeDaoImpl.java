package com.pack.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.model.Employee;
import com.pack.service.EmployeeServiceImpl;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		log.info("Inside Dao saveEmployee()");
		sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public List<Employee> fetchEmployee() {
		// TODO Auto-generated method stub
		log.info("Inside Dao fetchEmployee()");
		Query query = sessionFactory.getCurrentSession().createQuery("from Employee e");
		List<Employee> empList = query.list();
		return empList;
	}

	@Override
	public Employee fetchEmployeeById(Integer empId) {
		// TODO Auto-generated method stub
		log.info("Inside Dao fetchEmployeeById()");
		Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		log.info("Inside Dao updateEmployee()");
		sessionFactory.getCurrentSession().update(employee);
	}

	@Override
	public void deleteEmployee(Integer eid) {
		// TODO Auto-generated method stub
		log.info("Inside Dao deleteEmployee()");
		Query query = sessionFactory.getCurrentSession().createQuery("delete from Employee e where e.id=:empid");
		query.setParameter("empid", eid);
		query.executeUpdate();
	}

}
