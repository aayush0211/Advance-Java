package pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long id;
   @Column(length = 80)
   public String name;
   @Column(name = "batting_avg")
   public double battingAvg;
   public int wickets;
   
   public BaseEntity() {
	   
   }
   
public BaseEntity(Long id, String name, double battingAvg, int wickets) {
	super();
	this.id = id;
	this.name = name;
	this.battingAvg = battingAvg;
	this.wickets = wickets;
}

public BaseEntity( String name, double battingAvg, int wickets) {
	super();
	
	this.name = name;
	this.battingAvg = battingAvg;
	this.wickets = wickets;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
