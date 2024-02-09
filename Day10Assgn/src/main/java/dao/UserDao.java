package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;

import pojos.User;

public interface UserDao {
//add a method to get user details under specific role n dob range
	List<User> getSelectedUsers(String role, Date begin, Date end) throws SQLException;

	// add a method for voter reg.
	String registerNewVoter(User newVoter) throws HibernateException;

	// add a method to delete user details
	String deleteUserDetails(int userId) throws HibernateException;

	// add a method to authenticate user
	User authenticateUser(String email, String pwd) throws HibernateException;
	//add a method to change voting status
	String updateVotingStatus(int voterId) throws HibernateException;
}
