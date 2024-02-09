package pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {
	@Column(name = "date_birth")
      private LocalDate dob;
	@ManyToOne
	  private Team myTeam;
	
	public Player() {
		
	}
	public Player( String name, LocalDate dob, double battingAvg, int wickets) {
		super( name, battingAvg, wickets);
		this.dob = dob;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Team getMyTeam() {
		return myTeam;
	}
	public void setMyTeam(Team myTeam) {
		this.myTeam = myTeam;
	}
	
	
}
