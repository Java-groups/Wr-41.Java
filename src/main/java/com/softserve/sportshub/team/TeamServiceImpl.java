package com.softserve.sportshub.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{
    private final TeamDtoMapper mapper = new TeamDtoMapper();
    @Autowired
    private TeamDao teamDao;

    @Override
    public List<TeamDto> findAll() {
        return teamDao.findAll().stream().map(mapper::mapToTeamDto).toList();
    }

    @Override
    public List<TeamDto> findByName(String name) {
        return teamDao.findByName(name).stream().map(mapper::mapToTeamDto).toList();
    }

    @Override
    public TeamDto findTeamByName(String name) {
        return mapper.mapToTeamDto(teamDao.findExactTeamByName(name));
    }
}
