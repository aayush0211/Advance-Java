package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class RemoveDepartment {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = getFactory()) {
			// create dao instance
			DepartmentDao deptDao = new DepartmentDaoImpl();
			System.out.println("enter department name which will be deleted : ");
		String message =	deptDao.deleteDepartment(sc.next());
		System.out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
