package com.app.service;

import java.util.List;

import com.app.pojos.Team;

public interface TeamService {
      List<String> getTeamsAbbreviations();
      Team getTeamFromAbr(String abbr);
}
