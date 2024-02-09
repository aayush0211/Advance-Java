package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;
import pojos.User;

public interface CandidateDao {
	List<Candidate> getAllCandidates() throws SQLException;

	User getAuthentication(String email, String password) throws SQLException;
	
	String voteToCandidate(int candidateId,User user)throws SQLException;
	
	User getAuthenticationAdmin(String email ,  String password) throws SQLException;
    List<Candidate> getTwoCandidatesMaxVotes(int numberOfCandidates)throws SQLException;
	void cleanup() throws SQLException;
}
