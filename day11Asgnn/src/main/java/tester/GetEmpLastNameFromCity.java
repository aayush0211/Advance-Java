package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import java.util.*;
import dao.AddressDao;
import dao.AddressDaoImpl;
import pojos.Address;

public class GetEmpLastNameFromCity {
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			// create dao instance
			AddressDao adrDao = new AddressDaoImpl();
			
//			System.out.println(
//					"Enter address details : first line,  second line,  city,  state,  country,	 pincode");
			// create transient entity /pojo
		//	Address adr = new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
			//accept dept id
			System.out.println("Enter city :");			
		List<String> adr = adrDao.displayLastNameOfEmpAndAddress(sc.next());
  
	  System.out.println(adr);

        
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
