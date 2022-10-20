package com.softserve.sportshub.team;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TeamDaoImpl implements TeamDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Team team) {
        entityManager.persist(team);
    }

    @Override
    public List<Team> findAll() {
        List<Team> teams = entityManager.createQuery("SELECT team FROM Team team ")
                .getResultList();
        return teams;
    }

    @Override
    public List<Team> findByName(String teamName) {
        List<Team> teams = entityManager.createQuery(
                        "SELECT team FROM Team team WHERE team.teamName LIKE CONCAT('%',:teamName,'%')")
                .setParameter("teamName", teamName)
                .getResultList();
        return teams;
    }

    @Override
    public Team findExactTeamByName(String teamName) {
        TypedQuery<Team> q = entityManager.createQuery(
                        "SELECT team FROM Team team WHERE team.teamName = :teamName", Team.class)
                .setParameter("teamName", teamName);
        return q.getSingleResult();
    }
}
