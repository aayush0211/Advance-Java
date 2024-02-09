package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Team;

public interface TeamDao {
         Team getTeam(int teamId)throws SQLException;
         List<Team> getAllTeam()throws SQLException;
}
