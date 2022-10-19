package com.softserve.sportshub.team;

import com.softserve.sportshub.category.model.Category;
import com.softserve.sportshub.subcategory.model.Subcategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class TeamDtoMapperTest {
    private Team team;
    private TeamDto teamDto;
    private TeamDtoMapper mapper;

    @BeforeEach
    void setUp() {
        Category category = mock(Category.class);
        Subcategory subcategory = mock(Subcategory.class);
        Mockito.when(category.getName()).thenReturn("Basketball");
        Mockito.when(subcategory.getName()).thenReturn("NBA");
        Mockito.when(subcategory.getCategory()).thenReturn(category);
        team = new Team(1L,"LA Lakers", category, subcategory);
        teamDto = new TeamDto("Toronto Raptors", category, subcategory);

    }

    @Test
    void shouldMapTeamToTeamDto() {
        //given
        mapper = new TeamDtoMapper();

        //when
        TeamDto mapped = mapper.mapToTeamDto(team);

        //then
        Assertions.assertEquals("LA Lakers", mapped.getTeamName());
        Assertions.assertEquals("Basketball", mapped.getCategory().getName());
        Assertions.assertEquals("NBA", mapped.getSubcategory().getName());
    }

    @Test
    void shouldMapTeamDtoToTeam() {
        //given
        mapper = new TeamDtoMapper();

        //when
        Team mapped = mapper.mapToTeam(teamDto);

        //then
        Assertions.assertEquals("Toronto Raptors", mapped.getTeamName());
        Assertions.assertEquals("Basketball", mapped.getCategory().getName());
        Assertions.assertEquals("NBA", mapped.getSubcategory().getName());
    }


}
