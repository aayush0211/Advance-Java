package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager en;
	@Override
	public String addEmployee(Employee newEmployee) {
		en.persist(newEmployee);
		return "Your Employee has been Successfully Added";
	}

	@Override
	public List<Employee> getAllEmployee() {
		String jpql = "select e from Employee e";
		return en.createQuery(jpql, Employee.class).getResultList();
	}

	@Override
	public List<Employee> getAllEmployeeByCompany(String company) {
		String jpql = "select e from Employee e where e.companyName=:cn";
		return en.createQuery(jpql, Employee.class).setParameter("cn", company).getResultList();
	}

}
