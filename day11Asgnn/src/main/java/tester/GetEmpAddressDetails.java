package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AddressDao;
import dao.AddressDaoImpl;
import pojos.Address;


public class GetEmpAddressDetails {

	public static void main(String[] args) {
	
			try (Scanner sc = new Scanner(System.in);
					SessionFactory sf = getFactory()) {
				// create dao instance
				AddressDao adrDao = new AddressDaoImpl();
				
//				System.out.println(
//						"Enter address details : first line,  second line,  city,  state,  country,	 pincode");
				// create transient entity /pojo
			//	Address adr = new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
				//accept dept id
				System.out.println("Enter emp id :");			
			String adr = adrDao.displayEmployeeAddress(sc.nextLong());
            System.out.println(adr);
           
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
