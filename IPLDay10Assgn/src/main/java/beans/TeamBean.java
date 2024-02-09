package beans;

import java.util.List;

import org.hibernate.HibernateException;

import dao.TeamDaoImpl;
import pojo.Team;

public class TeamBean {
  private String message ; 
        private String teamName;
        private String ownerName;
        private String abbr;
        private int maxAge;
        private double battingAvg;
        private int wickets;
        private TeamDaoImpl teamDao;
        private Team team; //result
        public TeamBean() {
        	teamDao = new TeamDaoImpl();
        }
        
        public List<Team> getAllTeam()throws HibernateException{
        	return teamDao.getAllTeam();
        }
        
        public String addTeam() {
         team = new Team(teamName, abbr, ownerName, maxAge, battingAvg, wickets);
         message = teamDao.addNewTeam(team);
         if(message.equals("Team registration failed!!!!")) {
        	 return "add_team";
         }
         return "logout";
        }
        
        
		public Team getTeam() {
			return team;
		}

		public void setTeam(Team team) {
			this.team = team;
		}

		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getTeamName() {
			return teamName;
		}
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}
		public String getOwnerName() {
			return ownerName;
		}
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		public String getabbr() {
			return abbr;
		}
		public void setabbr(String abbr) {
			this.abbr = abbr;
		}
		public int getMaxAge() {
			return maxAge;
		}
		public void setMaxAge(int maxAge) {
			this.maxAge = maxAge;
		}
		public double getBattingAvg() {
			return battingAvg;
		}
		public void setBattingAvg(double battingAvg) {
			this.battingAvg = battingAvg;
		}
		public int getWickets() {
			return wickets;
		}
		public void setWickets(int wickets) {
			this.wickets = wickets;
		}
        
        
        
}
