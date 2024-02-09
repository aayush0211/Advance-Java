package dao;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Candidate;
import static utils.HibernateUtils.*;
public class CandidateDaoImpl implements CandidateDao {

	@Override
	public List<Candidate> getAllCandidates() throws HibernateException {
		String jpql = "select * from candidate";
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Candidate>candidates=null;
		try {
			candidates = session.createQuery(jpql, Candidate.class).getResultList();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return candidates;
	}

	@Override
	public String incrementVotes(int candidateId) throws HibernateException {
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Candidate candidate = null;
		try {
			candidate = session.get(Candidate.class, candidateId);
			candidate.setVotes(candidate.getVotes()+1);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return "successfully updated votes"+candidate.getVotes();
	}

	@Override
	public List<Candidate> getTop2Candidates(int numbers) throws HibernateException {
		String jpql = "select c from candidate c order by votes desc limit=:num";
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Candidate>candidates=null;
		try {
			candidates = session.createQuery(jpql, Candidate.class).setParameter("num",numbers ).getResultList();
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return candidates;
		
	}

	@Override
	public List<Candidate> getPartywiseVotes() throws HibernateException {
		
		String jpql = "select c.party, c.votes from candidate c order by votes desc";
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Candidate>candidates=null;
		try {
			candidates = session.createQuery(jpql, Candidate.class).getResultList();
			tx.commit();
		}
		catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return candidates;
	}

	@Override
	public String addCandidate(Candidate newCandidate) throws HibernateException {
	
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(newCandidate);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return "new Candidate Added"+newCandidate.getCandidateId();
	}

}
