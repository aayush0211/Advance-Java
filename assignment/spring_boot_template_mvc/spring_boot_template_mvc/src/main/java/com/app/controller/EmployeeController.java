package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService es;
	
	@RequestMapping("/form")
	public String preForm(Model map , Employee newEmployee) {
		System.out.println("in form "+getClass());
		return "/add_employee_form";
	}
	
	@PostMapping("/add")
	public String addNewEmployee(Model map , Employee newEmployee) {
		String company = newEmployee.getCompanyName().toUpperCase();
		newEmployee.setCompanyName(company);
	 String msg = es.addEmp(newEmployee);
	 map.addAttribute("msg", msg);
	
	 return "/index";
	}
	@GetMapping("/all")
	public String getAllEmployee(Model map){
		map.addAttribute("list", es.getAllEmployee());
		return "/all_employee";
	}
	@GetMapping("/all_by")
	public String preAllEmployee() {
		return "/company_form";
	}
	
	@PostMapping("/all_by_company")
	public String getAllEmployeeByCompany(Model map, @RequestParam("cmp")String selectCompany) {
	 List<Employee> emp =es.getAllEmployee();
	 String validCompany = selectCompany.toUpperCase();
	 	for(Employee e: emp) {
	 		if(e.getCompanyName().equals(validCompany)) {
	 			map.addAttribute("list", es.getAllEmployeeByCmp(selectCompany));
	 			return "/all_employee_by_company";
	 		}
	 	}
	 	String msg = "No Such Company is there!!!!";
	 	map.addAttribute("msg",msg);
	 	return "/company_form";
		
	}
}
