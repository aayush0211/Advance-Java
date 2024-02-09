package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDao;
import dao.TeamDaoImpl;

public class TestUpdateTeamById {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getFactory()) {
			System.out.println("hibernate booted successfully ! "+sf);
			//create dao instance n call method
			TeamDao dao=new TeamDaoImpl();
			
			System.out.println("Enter new Owner name and maxAge and Team Id respectfully : ");
			
			System.out.println(dao.updateTeam(sc.next(),sc.nextInt(),sc.nextInt()));
	
		} //sf.close() --> DBCP cleaned up ...
	catch(Exception e) {
		e.printStackTrace();
	}

	}

}
