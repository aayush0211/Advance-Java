package dao;

import pojos.Team;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.util.List;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addNewTeam(Team newTeam) throws HibernateException {
		Session session = getFactory().getCurrentSession(); // getCurrentSession instead of openSession as it is auto
															// closeable and managed by Hibernate

		Transaction tx = session.beginTransaction();

		try {

			session.save(newTeam);

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return "new Team Successfull add " + newTeam.getTeamId();
	}

	@Override
	public Team getTeamDetails(String abbr) throws HibernateException {
		String jpql = "select t from Team t where t.abbreviation=:abbr";
		Session session = getFactory().getCurrentSession(); // getCurrentSession instead of openSession as it is auto
															// closeable and managed by Hibernate

		Transaction tx = session.beginTransaction();
		Team team = null;
		try {

			team = session.createQuery(jpql, Team.class).setParameter("abbr", abbr).getSingleResult();

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return team;
	}

	@Override
	public String updateTeam(String owner, int age, int id) throws HibernateException {
			
		Session session = getFactory().getCurrentSession(); // getCurrentSession instead of openSession as it is auto
		// closeable and managed by Hibernate

Transaction tx = session.beginTransaction();
Team team = null;
try {

	team = session.get(Team.class, id);
		team.setOwner(owner);
		team.setMaxAge(age);
		tx.commit();

} catch (Exception e) {
if (tx != null) {
tx.rollback();
}
throw e;
}
return "Successfully Updated "+team;
	}

	@Override
	public List<Team> getTeamByMaxAge(int age) throws HibernateException {
		String jpql = "select t from Team t where t.maxAge>:age";
		Session session = getFactory().getCurrentSession(); // getCurrentSession instead of openSession as it is auto
															// closeable and managed by Hibernate

		Transaction tx = session.beginTransaction();
		List<Team> team = null;
		try {

			team = session.createQuery(jpql, Team.class).setParameter("age", age).getResultList();

			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return team;
	}
	
	}


