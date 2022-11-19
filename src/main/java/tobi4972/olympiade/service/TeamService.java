package tobi4972.olympiade.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobi4972.olympiade.model.Team;
import tobi4972.olympiade.repository.TeamRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TeamService implements ITeamService {

    private final TeamRepository repo;

    public TeamService(TeamRepository repo) {
        this.repo = repo;
    }


    @Override
    public Set<Team> findAll() {
        return new HashSet<Team>(repo.findAll());
    }

    @Override
    public Team save(Team object) {
        return repo.save(object);
    }

    @Override
    public void deleteBy(Long aLong) {
        repo.deleteById(aLong);
    }

    @Override
    public Optional<Team> findById(Long aLong) {

        return repo.findById(aLong);
    }


    @Override
    public Set<Team> findAllByTournamentID(Long tournamentID) {
        return repo.getAllByTournamentId(tournamentID);
    }
}
