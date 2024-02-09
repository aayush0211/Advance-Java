package dao;

import java.util.List;

import org.hibernate.HibernateException;

import pojos.Team;

public interface TeamDao {
//add a method to insert new team details
	String addNewTeam(Team newTeam) throws HibernateException;
	Team getTeamDetails(String abbr)throws HibernateException;
	String updateTeam(String owner, int age, int id) throws HibernateException;
	List<Team> getTeamByMaxAge(int age) throws HibernateException;
}
