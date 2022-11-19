package tobi4972.olympiade.service;
import tobi4972.olympiade.model.User;

import java.util.Set;


public interface IUserService extends CrudService<User, Long>{

    void deleteAllByTournamentID(Long tournamentId);

    Set<User> findByTournamentID(Long tournamentId);
}
