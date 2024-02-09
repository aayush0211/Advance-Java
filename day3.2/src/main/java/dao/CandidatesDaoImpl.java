package dao;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;
import static utils.DBUtils.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;
import pojos.User;

public class CandidatesDaoImpl implements CandidateDao {

	private Connection connection;
	private PreparedStatement pst;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;
	private PreparedStatement pst5;
	private java.sql.CallableStatement cst1;

	public CandidatesDaoImpl() throws SQLException {
		connection = getConnection();
		pst = connection.prepareStatement("select * from candidates");
		pst2 = connection.prepareStatement("select * from users where email=? and password=?");
		pst3 = connection.prepareStatement("select * from candidates where id=?");
		cst1 = connection.prepareCall("{call incrementVoting(?,?,?)}");// out parameter can't set only get
		cst1.registerOutParameter(3, Types.BOOLEAN);// out parameter must be registered to jvm
		/*
		 * Procedure delimiter &&
		 * 
		 * create procedure incrementVoting(IN can_id int , IN user_id tinyint, OUT
		 * state boolean) begin
		 * 
		 * declare vote int ; select votes into vote from candidates where id = can_id;
		 * set vote = vote+1; update candidates set votes = vote where id = can_id;
		 * update users set status = 1 where id = user_id; select status into state from
		 * users where id = user_id;
		 * 
		 * end &&
		 * 
		 * delimiter ;
		 */
		pst4 = connection.prepareStatement("select * from users where email = ? and password =? and role=?");
       pst5 = connection.prepareStatement(" select * from candidates order by votes desc limit ?");
	}
	

	@Override
	public List<Candidate> getTwoCandidatesMaxVotes(int numberOfCandidates) throws SQLException {
		pst5.setInt(1, numberOfCandidates);
		List<Candidate> list = new ArrayList<Candidate>();
		try(ResultSet rst = pst5.executeQuery()){
			while(rst.next())
			list.add(new Candidate(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return list;
	}


	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> candidates = new ArrayList<Candidate>();
		try (ResultSet rst = pst.executeQuery()) {// executeQuery use bcoz we use select query
			while (rst.next()) { // it repeatation depend on numbers of rows in resultset
				candidates.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
			}
		}
		return candidates;
	}

	@Override
	public void cleanup() throws SQLException {
		if (pst != null)
			pst.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (cst1 != null)
			cst1.close();
		closeConnection();
		System.out.println("user dao cleaned up !");
	}

	@Override
	public User getAuthentication(String email, String password) throws SQLException {
		pst2.setString(1, email);
		pst2.setString(2, password);
		try (ResultSet rst = pst2.executeQuery()) {
			User user = null;

			while (rst.next()) {
				user = new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
			}
			if (user == null)
				System.out.println("Invalid user!!!");
			else
				System.out.println("Authantication successfully done!!!");
			return user;

		}

	}

	@Override
	public String voteToCandidate(int candidateId, User user) throws SQLException {
		pst3.setInt(1, candidateId);
		Candidate candidate = null;
		try (ResultSet rst = pst3.executeQuery()) {
			while (rst.next())
				candidate = new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4));
		}
		if (candidate == null) {
			return "Candidate not found";
		} else {
			cst1.setInt(1, candidateId);
			cst1.setInt(2, user.getUserId());
			cst1.execute();
			System.out.println("user voting status : " + cst1.getBoolean(3));
			return "Voting Successfull to Candidate:  " + candidate.getName() + " Party name : " + candidate.getParty();
		}

	}

	@Override
	public User getAuthenticationAdmin(String email, String password) throws SQLException {
		pst4.setString(1, email);
		pst4.setString(2, password);
		pst4.setString(3, "admin");
		User user = null;
		try (ResultSet rst = pst4.executeQuery()) {
			while (rst.next())
				user = new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
		}
		if(user==null) {
			System.out.println("Invalid Authentication!!!");
			return user;
		}
		System.out.println("Admin Authentication successfull!!!");
		return user;
	}

}
