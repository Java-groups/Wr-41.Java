package com.softserve.sportshub.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/getall")
    public List<TeamDto> getTeams() {
        return teamService.findAll();
    }

    @PostMapping("/matches=")
    public List<TeamDto> findAllTeamsWithName(@RequestBody String name) {
        return teamService.findByName(name);
    }

    @PostMapping("/lookFor=")
    public TeamDto findTeamByName(@RequestBody String name) {
        return teamService.findTeamByName(name);
    }


}
