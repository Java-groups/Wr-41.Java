package com.softserve.sportshub.team;


import java.util.List;

public interface TeamDao {
    void save(Team team);
    List<Team> findAll();
    List<Team> findByName(String teamName);
    Team findExactTeamByName(String teamName);
}
