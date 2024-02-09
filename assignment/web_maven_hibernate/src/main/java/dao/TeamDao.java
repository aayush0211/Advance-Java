package dao;


import java.util.List;

import org.hibernate.HibernateException;

import pojo.Team;

public interface TeamDao {
     String addNewTeam(Team newTeam)throws HibernateException;
     Team getTeam(Long id)throws HibernateException;
     List<Team> getAllTeam()throws HibernateException;
}
