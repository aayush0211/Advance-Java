package tester;

import java.util.Scanner;

import dao.*;
import pojo.User;

public class VotingAppTest {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			CandidateDao dao = new CandidatesDaoImpl(); 
			boolean exit = false;
			while(!exit) {
                System.out.println("Choose Menu :\n1)Login as User\n2)Login as Admin\n"
                		+ "3)Register new User\n0)Exit");
				try {
					switch(sc.nextInt()) {
					case 1:System.out.println("Enter email and password : ");
					      User user = dao.getAuthentication(sc.next(), sc.next());
					      if(user!=null) {
					    	  if(user.isVotingStatus()==false) {
					    	  dao.getAllCandidates().forEach(System.out::println);
					    	  System.out.println("enter candidate id to be voted : ");
					    	 System.out.println(dao.voteToCandidate(sc.nextInt(),user));
					    	  }else
					    		  System.out.println("user already voted!!");
					      }
						break;
					case 2:System.out.println("enter email and password");
					  User admin = dao.getAuthenticationAdmin(sc.next(), sc.next());
					  if(admin!=null) {
						  System.out.println("enter how many candidates details you want who get maximum voting");
					  dao.getTwoCandidatesMaxVotes(sc.nextInt()).forEach(System.out::println);
					  }
						break;
					case 3:
						break;
					case 0:System.out.println("Thank you!!");
					exit=true;
						break;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
