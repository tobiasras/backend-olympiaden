package tobi4972.olympiade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tobi4972.olympiade.model.Team;

import java.util.Set;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Set<Team> getAllByTournamentId(Long tournamentID);

}
