package com.jbk.Spring_MVC_ERP.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.Spring_MVC_ERP.entity.Employee;
import com.jbk.Spring_MVC_ERP.service.EmployeeService;
// validations
// in controller
@Controller
public class AuthController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping(value="loginServlet")
	public ModelAndView login(@ModelAttribute Employee employee,HttpSession httpSession) {
		
		System.out.println(employee);
		Employee emp =service.login(employee);
		System.out.println(emp);
		if(emp!=null) {
			httpSession.setAttribute("username", emp.getUsername());
			httpSession.setAttribute("type", emp.getType());
			httpSession.setAttribute("eid", emp.getEid());
			return new ModelAndView("home");
		}
		else {
			return new ModelAndView("index","msg","Invalid Credentials");
		}
	}
}
