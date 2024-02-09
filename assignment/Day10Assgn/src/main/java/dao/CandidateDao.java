package dao;


import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.HibernateException;

import pojos.Candidate;

public interface CandidateDao {
//add a method to get all candidate details
	List<Candidate> getAllCandidates() throws HibernateException;

	// add a method to inc votes
	String incrementVotes(int candidateId) throws HibernateException;

	// add a method to get top 2 candidates
	List<Candidate> getTop2Candidates(int numbers) throws HibernateException;

	// add a method to get party wise votes
	List<Candidate> getPartywiseVotes() throws HibernateException;
	
	//add a candidate
	String addCandidate(Candidate newCandidate)throws HibernateException;

}
