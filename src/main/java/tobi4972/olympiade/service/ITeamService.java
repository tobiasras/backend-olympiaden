package tobi4972.olympiade.service;

import tobi4972.olympiade.model.Team;

import java.util.Set;

public interface ITeamService extends CrudService<Team, Long>{
    Set<Team> findAllByTournamentID(Long tournamentID);
}
