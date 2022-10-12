package com.jbk.Spring_MVC_ERP.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jbk.Spring_MVC_ERP.entity.Employee;

public interface EmployeeService {

	public Employee login(Employee employee);
	public Employee save(Employee employee);
	public List<Employee> listofEmployee();
	public Employee profile(String eid);
	public boolean deleteEmployee(String  eid);
	public boolean updateEmployee(Employee employee);
	public String uploadSheet(CommonsMultipartFile file,HttpSession httpSession);
}
