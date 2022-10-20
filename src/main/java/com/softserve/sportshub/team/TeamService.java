package com.softserve.sportshub.team;

import java.util.List;

public interface TeamService {
    List<TeamDto> findByName(String name);
    List<TeamDto> findAll();
    TeamDto findTeamByName(String name);
}
