package tobi4972.olympiade.service;
import org.springframework.stereotype.Service;
import tobi4972.olympiade.model.User;
import tobi4972.olympiade.repository.UserRepository;

import java.util.*;


@Service
public class UserService implements IUserService{


    private UserRepository repo;

    public UserService(UserRepository repo){
        this.repo = repo;
    }


    @Override
    public Set<User> findAll() {
        return new HashSet<>(repo.findAll());
    }

    @Override
    public User save(User object) {
        return repo.save(object);
    }

    @Override
    public void deleteBy(Long aLong) {
        repo.deleteById(aLong);
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return repo.findById(aLong);
    }


    @Override
    public void deleteAllByTournamentID(Long tournamentId) {
        repo.deleteAllByTournament_Id(tournamentId);
    }



    @Override
    public Set<User> findByTournamentID(Long tournamentId) {
        return repo.getUsersByTournament_Id(tournamentId);
    }


}
