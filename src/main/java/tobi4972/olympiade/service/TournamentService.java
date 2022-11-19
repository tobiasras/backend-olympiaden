package tobi4972.olympiade.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tobi4972.olympiade.model.Tournament;
import tobi4972.olympiade.repository.TournamentRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class TournamentService implements ITournamentService{

    private TournamentRepository repo;
    private IUserService userService;

    public TournamentService(TournamentRepository repo, IUserService userService){
        this.repo = repo;
        this.userService = userService;
    }

    @Override
    public Set<Tournament> findAll() {
        return new HashSet<>(repo.findAll());
    }

    @Override
    public Tournament save(Tournament object) {
        return repo.save(object);
    }

    @Override
    public void deleteBy(Long aLong) {
        // needs to delete all users for tournaments first
        userService.deleteAllByTournamentID(aLong);
        repo.deleteById(aLong);
    }

    @Override
    public Optional<Tournament> findById(Long aLong) {
        return repo.findById(aLong);
    }



}
