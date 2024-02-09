package dao;

import static dbutils.DBUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Candidate;
import pojo.User;

public class CandidatesDaoImpl implements CandidateDao {

	private Connection connection;
	private PreparedStatement pst;
	private PreparedStatement pst2;

	public CandidatesDaoImpl() throws SQLException {
		connection = openConnection();
		pst = connection.prepareStatement("select * from candidates");
		pst2= connection.prepareStatement("select * from users where email=? and password=?");
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
	

	public void cleanup() throws SQLException {
		if (pst != null)
			pst.close();
		if(pst2!=null)
			pst2.close();
		closeConnection();
		System.out.println("user dao cleaned up !");
	}

	@Override
	public User getAuthentication(String email, String password) throws SQLException {
		pst2.setString(1, email);
		pst2.setString(2, password);
	   try(ResultSet rst = pst2.executeQuery()){
		   User user=null;
		 
			   while(rst.next()) {
			   user= new User(rst.getInt(1),rst.getString(2), rst.getString(3), rst.getString(4),rst.getString(5),rst.getDate(6),rst.getBoolean(7),rst.getString(8)) ;
			   }
			  if(user==null)
				  System.out.println("Invalid user!!!");
			  else
				  System.out.println("Authantication successfully done!!!");
			   return user;
			   
		   
	   }
		
	}

}
