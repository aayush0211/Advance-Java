package dao;

import java.sql.*;

import pojos.Player;
import static utils.DBUtils.*;

public class PlayerDaoImpl implements PlayerDao {
	private Connection cn;
	private PreparedStatement pst1;
	public PlayerDaoImpl() throws SQLException {
		super();
		cn = getCn();
		pst1 = cn.prepareStatement("insert into players values(default,?,?,?,?,?,?)");
		System.out.println("player dao created");
	}
	
	public String addPlayerToTeam(Player newPlayer, int teamId) throws SQLException {
		//set IN parameters
		//firstName,lastName, dob,batting_avg,wickets_taken,team_id
		
		pst1.setString(1, newPlayer.getFirstName());
		pst1.setString(2, newPlayer.getLastName());
		pst1.setDate(3, newPlayer.getDob());
		pst1.setDouble(4, newPlayer.getBattingAvg());
		pst1.setInt(5, newPlayer.getWicketsTaken());
		pst1.setInt(6, teamId);
		
		///Execute Update(DML)
		int rows = pst1.executeUpdate();
		if(rows==1) {
			return "New Player added to the team...";
		}
		return "Failed to add new Player";
		
	}
	
	public void cleanUp() throws SQLException {
		if(pst1!=null) {
			pst1.close();
		}
		System.out.println("player dao cleaned up.....");
	}
}
