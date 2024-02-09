package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Team;


@Repository
public class TeamDaoImpl implements TeamDao {
	@Autowired
private EntityManager en;
	@Override
	public List<String> getteamsAbbreviations() {
	   String jpql = "select t.abbreviation from Team t";
		
	    return en.createQuery(jpql, String.class).getResultList();
	}
	@Override
	public Team getTeamFromAbbr(String abbr) {
		String jpql = "select t from Team t where t.abbreviation=:abbr";
		
		return en.createQuery(jpql, Team.class).setParameter("abbr",abbr).getSingleResult();
		
	}

}
