package beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
//props 
	private UserDaoImpl userDao;// dependency
	private User userDetails;// result
	// clnt info
	private String email;
	private String pass;
	private String firstName;
	private String lastName;
	private String dob;

	// def ctor must be present
	public UserBean() throws SQLException {
		// create user dao instance
		userDao = new UserDaoImpl();
		System.out.println("user bean created...");
	}

	// generate getter n setter
	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) { // should match with req. parameter
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setPass(String pass) {// should match with req. parameter
		this.pass = pass;
	}

	// add a B.L method to authenticate user
	public String authenticateUser() throws SQLException { // no arguments req. data already t.f.'r
		System.out.println("in JB B.L auth user " + email + " " + pass);
		// JB ---> DAo's method
		userDetails = userDao.authenticateUser(email, pass);
		if (userDetails == null) // => invalid login
			return "login"; // JB rets dyn navigational outcome (i.e telling JSP where to take the clnt
							// next)
		// => login successful
		if (userDetails.getRole().equals("admin"))
			return "admin_page";
		// => voter
		if (userDetails.isVotingStatus())
			return "logout";
		// => voter not yet voter
		return "candidate_list";
	}

	public String registerNewVoter() throws SQLException {
		/*
		 * validate age -- invalid -- err msg create user(voter) instance then invoke
		 * Dao's method return the status to the caller
		 */

		LocalDate dobs = LocalDate.parse(dob);
		if (Period.between(dobs, LocalDate.now()).getYears() >= 21) {

			userDetails = new User(firstName, lastName,email,pass, Date.valueOf(dob), false,"voter");
			return userDao.registerNewVoter(userDetails);
			
		} else {
			return "Invalid age";
		}
		
	}
}
