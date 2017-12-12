package com.stackroute.springdao.dao;

import java.util.List;

import com.stackroute.springdao.model.Employee;

public interface EmployeeDAO {

	public List<Employee> getAllEmployee();
	public boolean sendData(Employee employee);
}
