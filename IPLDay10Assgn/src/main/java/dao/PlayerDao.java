package dao;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.hibernate.HibernateException;

import pojo.Player;

public interface PlayerDao {
      String addPlayer(Player newPlayer, Long teamId)throws HibernateException;
      
     List<Player> getAllPlayerByTeam(Long teamId)throws HibernateException;
    
     
}
