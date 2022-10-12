package com.jbk.Spring_MVC_ERP.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.Spring_MVC_ERP.entity.Employee;
import com.jbk.Spring_MVC_ERP.service.EmployeeService;
// main controller class
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/")
	public String indexPage() {

		return "index";
	}

	@RequestMapping(value = "/importExportEmployee")
	public String importExportEmployee() {
		return "importExportEmployee";
	}
	
	@RequestMapping(value = "/addEmployeePage")
	public String addEmployeePage() {
		return "addEmployee";
	}

	// Add new employee
	@PostMapping(value = "/addEmployee")
	public ModelAndView addEmployee(@ModelAttribute Employee employee) {
		Employee emp = service.save(employee);
		if (emp != null) {
			return new ModelAndView("addEmployee", "msg", "Saved Successfully !!");
		} else {
			return new ModelAndView("addEmployee", "msg", "Something Wrong !!");
		}
	}

	// List of Employee
	@GetMapping(value = "/listofEmployee")
	public ModelAndView listofEmployee() {
		List<Employee> list = service.listofEmployee();
		return new ModelAndView("listofEmployee", "employees", list);
	}
	
	// Profile
	@GetMapping(value="/profileEmployee")
	public ModelAndView profileEmployee(@RequestParam String eid) {
		Employee employee = service.profile(eid);
		return new ModelAndView("profile","employee",employee);
	}
	
	// Update
	@PostMapping(value="/updateEmployee")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		boolean b = service.updateEmployee(employee);
		if(b) {
			return new ModelAndView("profile","msg","Profile Updated !!");
		}
		else {
			return new ModelAndView("profile","msg","Profile Not Updated !!");
		}
	}
	
	// Delete
		@GetMapping(value="/deleteEmployee")
		public ModelAndView deleteEmployee(@RequestParam String eid) {
			Employee employee = service.profile(eid);
			return new ModelAndView("profile","employee",employee);
			/*
			 * boolean b = service.deleteEmployee(eid); if(b) { return new
			 * ModelAndView("home","msg","Profile Deleted !!"); } else { return new
			 * ModelAndView("home","msg","Profile Not Deleted !!"); }
			 */
		}
	
	// upload 
		@PostMapping(value="/uploadsheet")
		public ModelAndView uploadsheet(@RequestParam CommonsMultipartFile file,HttpSession httpSession) {
			String msg = service.uploadSheet(file, httpSession);
			return new ModelAndView("home","msg",msg);
		}

}
