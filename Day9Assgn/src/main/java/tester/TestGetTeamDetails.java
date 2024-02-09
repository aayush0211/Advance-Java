package tester;
import pojos.*;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.*;
public class TestGetTeamDetails {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in);
				SessionFactory sf=getFactory()) {
			System.out.println("hibernate booted successfully ! "+sf);
			//create dao instance n call method
			TeamDao dao=new TeamDaoImpl();
			
			System.out.println("Team Abbreviation : ");
			
			System.out.println(dao.getTeamDetails(sc.next()));
	
		} //sf.close() --> DBCP cleaned up ...
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}
