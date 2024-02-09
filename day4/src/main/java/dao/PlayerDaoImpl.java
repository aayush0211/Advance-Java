package dao;

import static utils.DBUtils.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Player;

public class PlayerDaoImpl implements PlayerDao {
	private PreparedStatement pst1;
	private Connection cn;

	public PlayerDaoImpl() throws SQLException {
		cn = getConnection();
		pst1 = cn.prepareStatement("select * from players where team_id=?");
	}

	@Override
	public List<Player> getAllPlayersOfGivenTeam(int teamId) throws SQLException {
		pst1.setInt(1, teamId);
		List<Player> list = new ArrayList<Player>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {// cursor on 0th or before row so rst.next() it move on 1st row
				list.add(new Player(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getDouble(5),
						rst.getInt(6), rst.getInt(7)));
			}
		}
		return list;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();

	}
}
