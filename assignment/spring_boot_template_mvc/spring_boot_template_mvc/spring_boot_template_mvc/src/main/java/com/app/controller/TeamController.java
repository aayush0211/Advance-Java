package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.TeamService;

import java.util.*;

@Controller

public class TeamController {
@Autowired
private TeamService ts;

public TeamController() {
	System.out.println("in cnst'r of "+getClass());
}
@GetMapping("/")
public String getTeamAbbr(Model map){
	List<String>abbrs = ts.getTeamsAbbreviations();
	map.addAttribute("abbr", abbrs);
	return "/teams/add_player_form";
}


}
