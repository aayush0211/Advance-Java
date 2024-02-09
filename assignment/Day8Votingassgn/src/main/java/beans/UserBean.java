package beans;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedHashMap;
import java.util.List;

import dao.CandidateDaoImpl;
import dao.UserDaoImpl;
import pojos.Candidate;
import pojos.User;

public class UserBean {
//props 
	private UserDaoImpl userDao;// dependency
	private CandidateDaoImpl candidateDao;//dependency
	private User userDetails;// result
	// clnt info
	private String email;
	private String pass;
	private String fname;
	private String lname;
	private String dob;
	private String party;
	//add another property to store the status mesg here only getter req'd
	private String message;
    private int cndId;
	// def ctor
	public UserBean() throws SQLException {
		// create user dao instance
		userDao = new UserDaoImpl();
		candidateDao = new CandidateDaoImpl();
		System.out.println("user bean created...");
	}

	public CandidateDaoImpl getCandidateDao() {
		return candidateDao;
	}
     
	
	
	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getCndId() {
		return cndId;
	}

	public void setCndId(int cndId) {
		this.cndId = cndId;
	}

	public void setCandidateDao(CandidateDaoImpl candidateDao) {
		this.candidateDao = candidateDao;
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

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	

	public String getMessage() {
		return message;
	}

	// add a B.L method to authenticate user
	public String authenticateUser() throws SQLException {
		System.out.println("in JB B.L auth user " + email + " " + pass);
		// JB ---> DAo's method
		userDetails = userDao.authenticateUser(email, pass);
		if (userDetails == null) // => invalid login
		{
			message="Invalid login , pls retry!";
			return "login"; // JB rets dyn navigational outcome (i.e telling JSP where to take the clnt
							// next)
		}
		//=> login successful
		message="successful login!";
		if(userDetails.getRole().equals("admin"))
			return "admin_page";
		//=> voter 
		if(userDetails.isVotingStatus())
			return "logout";
		//=> voter not yet voter
		return "candidate_list";
	}
	//add B.L method  to add a new voter
	public String registerNewVoter() throws SQLException{
		/*
		 * validate age --invalid --err mesg
		 * create user (voter) instance --invoke dao's method
		 * ret status to the caller
		 */
		LocalDate date=LocalDate.parse(dob);
		int age=Period.between(date, LocalDate.now()).getYears();
		if(age >= 21)
		{
			//valid i/ps
			//create transient (=not yet persistent) POJO 
			//firstName, String lastName, String email, String password, Date dob
			User user=new User(fname, lname, email, pass, Date.valueOf(date));
			//invoke dao's method for persistence(insert)
			user.setRole("voter");
			message = userDao.registerNewVoter(user);
			return "login";
		}
		else 
			message= "Voter reg failed : invalid age !!!!!!!!!!";
		return "register";
	}
	
	public List<Candidate> getAllCandidate()throws SQLException{
		return candidateDao.getAllCandidates();
	}
	public String updateVotingStatus()throws SQLException{
		return userDao.updateVotingStatus(userDetails.getUserId());
	}
    public String incrementVotes()throws SQLException{
    	return candidateDao.incrementVotes(cndId);
    }
    public List<Candidate> getTop2Candidates() throws SQLException{
    	return candidateDao.getTop2Candidates();
    }
    public String addNewCandidate()throws SQLException{
    	Candidate cnd = new Candidate(fname, party);
    	cnd.setVotes(0);
    	int raw = candidateDao.addCandidate(cnd);
    	if(raw==1) {
    		message="successfully registered!!!";
    		return "login";
    	}
    	message="Candidate Rijected!!!";
    	return "candidate_registration";
    }
    public LinkedHashMap<String, Integer> getPartywiseVotes() throws SQLException{
    	return candidateDao.getPartywiseVotes();
    }
}
