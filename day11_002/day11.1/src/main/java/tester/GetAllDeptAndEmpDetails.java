package tester;
import pojos.*;

import org.hibernate.SessionFactory;

import java.util.*;

import static utils.HibernateUtils.*;
import dao.DepartmentDao;
import dao.DepartmentDaoImpl;

public class GetAllDeptAndEmpDetails {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()){
		DepartmentDao deptDao = new DepartmentDaoImpl();
	List<Department>depts = deptDao.getAllDepatmentAndEmpDeatails();
	System.out.println("all department details are : ");
	for(Department d : depts) {
		System.out.println(d);
		d.getEmployees().forEach(System.out::println);
	}
		}
	}

}
