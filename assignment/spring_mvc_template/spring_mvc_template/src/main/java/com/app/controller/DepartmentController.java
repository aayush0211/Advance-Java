package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.Department;
import com.app.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
 public DepartmentController() {
	 System.out.println("in dept controller constructor"+getClass());
 }
 //add req handling method to send list of dept to the view layer
 @RequestMapping("/dept_list")
 
 public String getdepartmentResult(Model modelAttrMap) {
	 System.out.println("in list all dept"+modelAttrMap);//{}
	 List<Department> departmentDetails = deptService.departmentDetails();
	 modelAttrMap.addAttribute("dept_list", departmentDetails);
	 return "/list";//AVN:/WEB-INF/views/list.jsp-->D.S forwards-->list.jsp
 }
}
