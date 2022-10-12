package com.jbk.Spring_MVC_ERP.dao;

import java.util.List;

import com.jbk.Spring_MVC_ERP.entity.Employee;


public interface EmployeeDao {

	public Employee login(Employee employee);
	public Employee save(Employee employee);
	public List<Employee> listofEmployee();
	public Employee profile(String eid);
	public boolean deleteEmployee(String  eid);
	public boolean updateEmployee(Employee employee);
	public String saveList(List<Employee> list);
}
