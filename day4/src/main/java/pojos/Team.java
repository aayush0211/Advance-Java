package pojos;
// team_id | name     | abbrevation | owner  | max_age | batting_avg | wickets_taken
public class Team {
  private int teamId;
  private String name;
  private String abbrevation;
  private String owner;
  private int max_age;
  private double batting_avg;
  private int wickets_taken;
  
public Team(int teamId, String name, String abbrevation, String owner, int max_age, double batting_avg,
		int wickets_taken) {
	super();
	this.teamId = teamId;
	this.name = name;
	this.abbrevation = abbrevation;
	this.owner = owner;
	this.max_age = max_age;
	this.batting_avg = batting_avg;
	this.wickets_taken = wickets_taken;
}

public int getTeamId() {
	return teamId;
}

public void setTeamId(int teamId) {
	this.teamId = teamId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAbbrevation() {
	return abbrevation;
}

public void setAbbrevation(String abbrevation) {
	this.abbrevation = abbrevation;
}

public String getOwner() {
	return owner;
}

public void setOwner(String owner) {
	this.owner = owner;
}

public int getMax_age() {
	return max_age;
}

public void setMax_age(int max_age) {
	this.max_age = max_age;
}

public double getBatting_avg() {
	return batting_avg;
}

public void setBatting_avg(double batting_avg) {
	this.batting_avg = batting_avg;
}

public int getWickets_taken() {
	return wickets_taken;
}

public void setWickets_taken(int wickets_taken) {
	this.wickets_taken = wickets_taken;
}
  
  
  
}
