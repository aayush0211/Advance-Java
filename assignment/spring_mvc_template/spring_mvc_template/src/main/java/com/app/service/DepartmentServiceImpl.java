package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
   @Autowired
	private DepartmentDao dao;
   @Override
	public List<Department> departmentDetails() {
		
		return dao.getAllDepartments();
	}
}
