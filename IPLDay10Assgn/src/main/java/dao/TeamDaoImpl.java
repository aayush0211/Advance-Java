package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Team;
import static utils.HibernateUtils.*;

import java.util.List;

import javax.servlet.http.HttpSession;
public class TeamDaoImpl implements TeamDao {
     
	@Override
	public String addNewTeam(Team newTeam) throws HibernateException {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
	    String message = "Team registration failed!!!!";	
		try {//newTeam is in transient state
			session.save(newTeam);//select query run when commit\ now newTeam is in Persistent state
			tx.commit();//session.flush() session.close() cache distroy
			message="Team added successfully!!!";
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		return message;
	}

	@Override
	public Team getTeam(Long id) throws HibernateException {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
	    String message = "Team registration failed!!!!";
	    Team team=null;
		try {//newTeam is in transient state
			team = session.get(Team.class, id);//select query run when commit\ now newTeam is in Persistent state
			tx.commit();//session.flush() session.close() cache distroy
			message="Team added successfully!!!";
			
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		System.out.println(message);
		return team;
	}

	@Override
	public List<Team> getAllTeam() throws HibernateException {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
	    String jpql = "select t from Team t";
	    List<Team> teamlist=null;
		try {//newTeam is in transient state
			teamlist = session.createQuery(jpql, Team.class).getResultList();
			tx.commit();//session.flush() session.close() cache distroy
			System.out.println(teamlist);
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		return teamlist;
	}

}
