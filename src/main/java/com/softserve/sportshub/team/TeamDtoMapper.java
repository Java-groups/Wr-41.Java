package com.softserve.sportshub.team;



public class TeamDtoMapper {

    public Team mapToTeam(TeamDto teamDto) {
        Team team = new Team();
        team.setTeamName(teamDto.getTeamName());
        team.setCategory(teamDto.getCategory());
        team.setSubcategory(teamDto.getSubcategory());
        return team;
    }

    public TeamDto mapToTeamDto(Team team) {
        TeamDto teamDto = new TeamDto();
        teamDto.setTeamName(team.getTeamName());
        teamDto.setCategory(team.getCategory());
        teamDto.setSubcategory(team.getSubcategory());
        return teamDto;
    }

}
