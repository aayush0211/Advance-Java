package com.app.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Player;

@Repository
public class PlayerDaoImpl implements PlayerDao {
@Autowired
private EntityManager en;
	
	@Override
	public String addNewPlayer(Player newPlayer) {
		
		return null;
	}

}
