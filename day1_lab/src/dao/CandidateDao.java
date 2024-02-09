package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Candidate;
import pojo.User;

public interface CandidateDao {
	List<Candidate> getAllCandidates() throws SQLException;
	
	User getAuthentication(String email,String password)throws SQLException;

}
