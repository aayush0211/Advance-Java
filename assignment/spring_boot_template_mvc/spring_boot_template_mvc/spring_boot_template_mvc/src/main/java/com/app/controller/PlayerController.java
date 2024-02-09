package com.app.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Player;
import com.app.service.PlayerService;

@Controller
@RequestMapping("/player")
public class PlayerController {

	@Autowired
private PlayerService ps;

@PostMapping("/add")
String addNewPlayer(@RequestParam("myTeam")String teamAbbr, @RequestParam("fn")String firstName, @RequestParam("ln")String lastName,
		@RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob, @RequestParam("avg")double battingAvg,
		@RequestParam("wickets")int wickets,Model map) {
	Player newPlayer = new Player(firstName, lastName,dob, battingAvg, wickets);
String msg =	ps.addPlayer(teamAbbr, newPlayer);
map.addAttribute("msg", msg);
return "/teams/add_player_form";

	
}
}
