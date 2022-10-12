package com.jbk.Spring_MVC_ERP.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Spring_MVC_ERP.entity.Employee;

@Repository
public class EmployeeDao_impl implements EmployeeDao {

	// All session method work with primary key
	@Autowired
	private SessionFactory sf;

	@Override
	public Employee login(Employee employee) {

		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class);

		SimpleExpression usernameExpression = Restrictions.eq("username", employee.getUsername());
		SimpleExpression passwordExpression = Restrictions.eq("password", employee.getPassword());
		criteria.add(Restrictions.and(usernameExpression, passwordExpression));

		Employee emp = (Employee) criteria.uniqueResult();
		session.close();
		return emp;
	}

	@Override
	public Employee save(Employee employee) {
		boolean b = false;
		Session session = sf.openSession();

		try {
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			b = true;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		session.close();

		return employee;
	}

	@Override
	public List<Employee> listofEmployee() {
		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> list = criteria.list();
		session.close();
		return list;
	}

	@Override
	public Employee profile(String eid) {
		Session session = sf.openSession();
		Employee employee = session.get(Employee.class, eid);// session.get is Work only on primary key
		return employee;
	}

	@Override
	public boolean deleteEmployee(String eid) {
		boolean b = false;
		Session session = sf.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.delete(eid);
			transaction.commit();
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		session.close();
		return b;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		boolean b = false;
		Session session = sf.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		session.close();
		return b;
	}

	// Save to database
	public String saveList(List<Employee> list) {
		try {
			for (Employee employee : list) {
				Session session = sf.openSession();
				Transaction transaction = session.beginTransaction();
				session.save(employee);
				transaction.commit();
				session.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return list.size() + " Record Saved !!";
	}
}
