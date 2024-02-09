package tester;
import java.util.List;


import dao.*;
import pojo.Candidate;
public class TestCandidateLayerApp {

	public static void main(String[] args) {
		try {
		CandidatesDaoImpl dao = new CandidatesDaoImpl();
			List<Candidate> allCandidates = dao.getAllCandidates();
			allCandidates.stream().forEach(System.out::println);
			
			//authentication
		System.out.println(dao.getAuthentication("rama@gmail.com", "ram#123"));
		dao.cleanup();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}
