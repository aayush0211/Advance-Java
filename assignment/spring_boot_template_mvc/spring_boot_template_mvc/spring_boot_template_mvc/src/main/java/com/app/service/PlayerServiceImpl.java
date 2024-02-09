package com.app.service;

import java.time.LocalDate;
import java.time.Period;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PlayerDao;
import com.app.dao.TeamDao;
import com.app.pojos.Player;
import com.app.pojos.Team;
@Service
@org.springframework.transaction.annotation.Transactional
public class PlayerServiceImpl implements PlayerService {
@Autowired
private PlayerDao playerDao;
@Autowired
private TeamDao teamDao;
String message;
	@Override
	public String addPlayer(String abbr, Player newPlayer) {
	Team team =	teamDao.getTeamFromAbbr(abbr);
	System.out.println(team);
	LocalDate vdob =  newPlayer.getDob();
	int playerAge = Period.between(vdob, LocalDate.now()).getYears();
	if(team.getMaxAge()>=playerAge) {
		if(team.getBattingAvg()<=newPlayer.getBattingAvg()) {
			if(team.getWicketsTaken()<=newPlayer.getWicketsTaken()) {
				team.addPlayer(newPlayer);
				System.out.println(team.getPlayers());
//				playerDao.addNewPlayer(newPlayer);
				message="successfully added!!!";
				
			}else {
				message = "wickets are not in range!!!";
				
			}
		}else {
			message="batting avg not in range!!!";
			
		}
	}else {
		message = "age not in range!!";
		
	}
		return message;
	}

}
