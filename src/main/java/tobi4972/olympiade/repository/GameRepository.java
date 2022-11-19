package tobi4972.olympiade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tobi4972.olympiade.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
