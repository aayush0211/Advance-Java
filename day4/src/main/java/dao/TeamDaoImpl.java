package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;
import pojos.Team;

public class TeamDaoImpl implements TeamDao {
      private Connection cn;
      private PreparedStatement pst1;
      private PreparedStatement pst2;
      
      
	public TeamDaoImpl() throws SQLException {
		cn = getConnection();
		pst1 = cn.prepareStatement("select * from teams where team_id=?");
		pst2 = cn.prepareStatement("select * from teams");
	}

	@Override
	public Team getTeam(int teamId) throws SQLException {
		pst1.setInt(1, teamId);
		Team team=null;
		try(ResultSet rst = pst1.executeQuery()){
			if(rst.next())
				team = new Team(rst.getInt(1), rst.getString(2), rst.getString(3),
						rst.getString(4), rst.getInt(5), rst.getDouble(6), rst.getInt(7));
		}
		return team;
	}

	@Override
	public List<Team> getAllTeam() throws SQLException {
		List<Team>list = new ArrayList<Team>();
		try(ResultSet rst = pst2.executeQuery()){
			while(rst.next())
				list.add(new Team(rst.getInt(1), rst.getString(2), rst.getString(3),
						rst.getString(4), rst.getInt(5), rst.getDouble(6), rst.getInt(7)));
		}
		return list;
	}
	
	public void cleanUp() throws SQLException {
		if(cn!=null)
			cn.close();
		if(pst1!=null)
			pst1.close();
		if(pst2!=null)
			pst2.close();
	}

}
