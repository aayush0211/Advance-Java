package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Player;

public interface PlayerDao {
        List<Player> getAllPlayersOfGivenTeam(int teamId) throws SQLException;
}
