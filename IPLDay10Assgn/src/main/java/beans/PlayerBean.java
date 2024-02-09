package beans;

import java.time.LocalDate;
import java.time.Period;

import org.hibernate.HibernateException;

import dao.PlayerDaoImpl;
import dao.TeamDaoImpl;
import pojo.Player;
import pojo.Team;

public class PlayerBean {
  private String message;
  private long teamId;
  private String playerName;
  private String dob;
  private double battingAvg;
  private int wickets;
  private Player player;
  private PlayerDaoImpl playerDao;
  private Team team;
  private TeamDaoImpl teamDao;
  public PlayerBean() {  //mandatory for creating instance of beans by WC
	  playerDao = new PlayerDaoImpl();
	  teamDao = new TeamDaoImpl();
  }
  
  public String addPlayer()throws HibernateException {
	  LocalDate validDob = LocalDate.parse(dob);
	   team = teamDao.getTeam(teamId);
	  player = new Player(playerName, validDob, battingAvg, wickets);
	  if(Period.between(validDob, LocalDate.now()).getYears()<=team.getMaxAge() && player.getBattingAvg()>=team.battingAvg &&
			  player.getWickets()>=team.wickets) {
		message = playerDao.addPlayer(player, teamId);
		return "logout";
	  }else {
		  message = "Unsuccessfully Register!!!!";
		  return "login";
	  }
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

public long getTeamId() {
	return teamId;
}

public void setTeamId(long teamId) {
	this.teamId = teamId;
}

public String getPlayerName() {
	return playerName;
}

public void setPlayerName(String playerName) {
	this.playerName = playerName;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
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

public Player getPlayer() {
	return player;
}

public void setPlayer(Player player) {
	this.player = player;
}
  
  
}
