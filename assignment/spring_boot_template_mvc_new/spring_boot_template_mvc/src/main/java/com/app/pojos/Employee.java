package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer empNo;
	@Column(length = 80 , name = "first_name")
	private String firstName;
	@Column(name = "last_name" , length = 70)
	private String lastName;
	@Column(length = 100)
	private String city;
	@Column(name = "company_name" , length = 120)
	private String companyName;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String city, String companyName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.companyName = companyName;
		
	}

	public Employee(Integer empNo, String firstName, String lastName, String city, String companyName) {
		super();
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.companyName = companyName;
	}

	public Integer getEmpNo() {
		return empNo;
	}
	
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", firstName=" + firstName + ", lastName=" + lastName + ", city=" + city
				+ ", companyName=" + companyName + "]";
	}
	
	
	
}
