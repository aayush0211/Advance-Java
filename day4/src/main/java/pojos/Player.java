package pojos;

import java.sql.Date;

//create table players(player_id int primary key auto_increment,first_name varchar(20),
//last_name varchar(20),dob date,batting_avg double,wickets_taken
//int,team_id int ,constraint fk_teams foreign key (team_id) references teams(team_id));
public class Player {
   private int playerId;
   private String firstName;
   private String lastName;
   private Date dob;
   private double battingAvg;
   private int wcktTaken;
   private int teamId;
public Player(int playerId, String firstName, String lastName, Date dob, double battingAvg, int wcktTaken, int teamId) {
	super();
	this.playerId = playerId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.battingAvg = battingAvg;
	this.wcktTaken = wcktTaken;
	this.teamId = teamId;
}
public int getPlayerId() {
	return playerId;
}
public void setPlayerId(int playerId) {
	this.playerId = playerId;
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
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public double getBattingAvg() {
	return battingAvg;
}
public void setBattingAvg(double battingAvg) {
	this.battingAvg = battingAvg;
}
public int getWcktTaken() {
	return wcktTaken;
}
public void setWcktTaken(int wcktTaken) {
	this.wcktTaken = wcktTaken;
}
public int getTeamId() {
	return teamId;
}
public void setTeamId(int teamId) {
	this.teamId = teamId;
}
   
   
}
