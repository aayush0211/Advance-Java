package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Player;
import pojo.Team;

import static utils.HibernateUtils.*
;public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayer(Player newPlayer, Long teamId) throws HibernateException {
		String message = "Player rejected!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Team team = session.get(Team.class, teamId);
			newPlayer.setMyTeam(team);
			tx.commit();
			message="Player added successfully!!";
		}catch (Exception e) {
			// TODO: handle exception
      
		if(tx!=null)
			tx.rollback();
		throw e;
		}
		return message;
	}

	@Override
	public List<Player> getAllPlayerByTeam(Long teamId) throws HibernateException {
		String jpql = "select p from Player p where p.abbr=:abbr";
		return null;
	}

}
