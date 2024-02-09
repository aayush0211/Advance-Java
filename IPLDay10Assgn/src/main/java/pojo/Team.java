package pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{
	
	@Column(name = "abbraviation",length = 15,unique = true)
     private String abbr;
	@Column(name = "owner_name",length = 90)
	private String ownerName;
	@Column(name = "max_age")
	private int maxAge;
	@OneToMany(mappedBy = "myTeam")
	private List<Player>players = new ArrayList<Player>();
	public Team( String name,String abbr,String ownerName,int maxAge, double battingAvg, int wickets) {
		super( name, battingAvg, wickets);
		this.abbr=abbr;
		this.ownerName=ownerName;
		this.maxAge=maxAge;
	}
	public Team() {
		
	}
	
	
	public Team(Long id, String name, double battingAvg, int wickets, String abbr, String ownerName, int maxAge) {
		super(id, name, battingAvg, wickets);
		this.abbr = abbr;
		this.ownerName = ownerName;
		this.maxAge = maxAge;
	}
	public void addNewPlayerInTeam(Player newPlayer) {
		players.add(newPlayer);
		newPlayer.setMyTeam(this);
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	@Override
	public String toString() {
		return "Team [ id=" + id + ", name="
				+ name +"abbr=" + abbr + ", ownerName=" + ownerName + ", maxAge=" + maxAge +  ", battingAvg=" + battingAvg + ", wickets=" + wickets + "]";
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	
	
}
