package beans;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;
import static utils.DBUtils.*;
public class PlayerBean {
           private PlayerDaoImpl playerDaoImpl;
           private TeamDaoImpl teamDaoImpl;
           private Team teamDetails;
           private Player playerDetails;
           private String firstName;
           private String lastName;
           private String abbreviation;
           private String dob;
           private String wickets;
           private String battingAvg;
           //create default cont'r of bean in which connection establish, invoke by WC
           //if parameter constr'r create and defAULT CONST'R NOT Create then wC can't make instance of bean
           //Instance not create arrive
           public PlayerBean()throws SQLException{
        	   openConnection();
        	   playerDaoImpl = new PlayerDaoImpl();
        	   teamDaoImpl = new TeamDaoImpl();
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

		public String getAbbreviation() {
			return abbreviation;
		}

		public void setAbbreviation(String abbreviation) {
			this.abbreviation = abbreviation;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getWickets() {
			return wickets;
		}

		public void setWickets(String wickets) {
			this.wickets = wickets;
		}

		public String getBattingAvg() {
			return battingAvg;
		}

		public void setBattingAvg(String battingAvg) {
			this.battingAvg = battingAvg;
		}

		public List<String> getAllTeams()throws SQLException{
        	   return teamDaoImpl.getTeamsAbbreviations();
        	    
           }
           
           public Team getTeamDetails()throws SQLException{
        	   return teamDaoImpl.getTeamDetails(abbreviation);
           }
           
}
