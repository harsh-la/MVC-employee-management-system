package com.jbk.Spring_MVC_ERP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	private String eid;
	@Column(unique=true,nullable=false)
	private String username;
	private String password;
	private String department;
	private String salary;
	private String type;
	private String question;
	private String answer;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String eid, String username, String password, String department, String salary, String type,
			String question, String answer) {
		super();
		this.eid = eid;
		this.username = username;
		this.password = password;
		this.department = department;
		this.salary = salary;
		this.type = type;
		this.question = question;
		this.answer = answer;
	}
	
	public Employee(String username, String password, String department, String salary, String type, String question,
			String answer) {
		super();
		this.username = username;
		this.password = password;
		this.department = department;
		this.salary = salary;
		this.type = type;
		this.question = question;
		this.answer = answer;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", username=" + username + ", password=" + password + ", department="
				+ department + ", salary=" + salary + ", type=" + type + ", question=" + question + ", answer=" + answer
				+ "]";
	}
	
	
}
