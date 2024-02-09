package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDao;
import dao.AddressDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Address;
import pojos.Employee;
import pojos.EmploymentType;

public class AddEmpAddress {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			// create dao instance
			AddressDao adrDao = new AddressDaoImpl();
			
			System.out.println(
					"Enter address details : first line,  second line,  city,  state,  country,	 pincode");
			// create transient entity /pojo
			Address adr = new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
			//accept dept id
			System.out.println("Enter dept id");			
			System.out.println(adrDao.enterEmpAddress(sc.nextLong(), adr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
