package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;

import pojos.Candidate;
import pojos.User;

public class UserDaoImpl implements UserDao {
	// state (fields)
	private Connection connection;
	private PreparedStatement pst1, pst2, pst3, pst4,pst5,pst6,pst7,pst8;

	// def ctor
	public UserDaoImpl() throws SQLException {
		// get cn from db utils
		connection = getConnection();
		pst1 = connection.prepareStatement(
				"select first_name,last_name,dob,status from users where role=? and dob between ? and ?");
		pst2 = connection.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		pst3 = connection.prepareStatement("delete from users where id=?");
		pst4 = connection.prepareStatement("select * from users where email=? and password=?");
		pst5 = connection.prepareStatement("select * from candidates");
		pst6 = connection.prepareStatement("update users set status = ? where id = ?");
		pst7 = connection.prepareStatement("update candidates set votes = ? where id = ?");
		pst8 = connection.prepareStatement("select * from candidates where id=?");
		System.out.println("user dao created!");
	}

	@Override
	public Candidate getCandidate(int id) throws SQLException {
		pst8.setInt(1, id);
		Candidate cnd = null;
		try(ResultSet rst = pst8.executeQuery()){
			if(rst.next()) {
				cnd = new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3),rst.getInt(4));
			}
		}
		return cnd;
	}

	@Override
	public void changeVotingStatus(User user) throws SQLException {
		pst6.setBoolean(1, true);
		pst6.setInt(2, user.getUserId());
		pst6.executeUpdate();
		
	}
	

	@Override
	public void increaseVotingStatus(Candidate candidate) throws SQLException {
		pst7.setInt(1, candidate.getVotes()+1);
		pst7.setInt(2, candidate.getId());
		pst7.executeUpdate();
	}

	@Override
	public List<User> getSelectedUsers(String role, Date begin, Date end) throws SQLException {
		// set IN params
		pst1.setString(1, role);
		pst1.setDate(2, begin);
		pst1.setDate(3, end);
		// exec query : execQuery() --- RST
		List<User> users = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				users.add(new User(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getBoolean(4)));
		} // JVM : rst.close()
		return users;// DAO rets populated list of users to tester.
	}

	@Override
	public String registerNewVoter(User newVoter) throws SQLException {
		// set IN params (first_name | last_name | email| password | dob| status | role
		pst2.setString(1, newVoter.getFirstName());
		pst2.setString(2, newVoter.getLastName());
		pst2.setString(3, newVoter.getEmail());
		pst2.setString(4, newVoter.getPassword());
		pst2.setDate(5, newVoter.getDob());
		pst2.setBoolean(6, false);
		pst2.setString(7, "voter");
		// exec : execUpdate
		int rowCount = pst2.executeUpdate();
		if (rowCount == 1)
			return "Voter registered....";
		return "Voter reg failed!!!!!!!!!!!!!";
	}

//TO DO : validate user role : voter 
	@Override
	public String deleteUserDetails(int userId) throws SQLException {
		// set IN param : user id
		pst3.setInt(1, userId);
		int rowCount = pst3.executeUpdate();
		if (rowCount == 1)
			return "Voter deleted....";
		return "Voter deletion failed!!!!!!!!!!!!!";

	}

	@Override
	public User authenticateUser(String email, String pwd) throws SQLException {
		// set IN params
		pst4.setString(1, email);
		pst4.setString(2, pwd);
		// exec query : execQuery() --> RST --> next
		try (ResultSet rst = pst4.executeQuery()) {
			if (rst.next())
				// int userId, String firstName, String lastName, String email, Date dob,
				// boolean votingStatus,
				// String role
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, rst.getDate(6),
						rst.getBoolean(7),rst.getString(8));
		}
		return null;
	}

	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		closeConnection();
		System.out.println("user dao cleaned up !");
	}

}
