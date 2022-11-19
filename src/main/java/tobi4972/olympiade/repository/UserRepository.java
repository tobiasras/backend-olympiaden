package tobi4972.olympiade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tobi4972.olympiade.model.User;

import javax.transaction.Transactional;
import java.util.Set;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    void deleteAllByTournament_Id(Long tournamentID);

    Set<User> getUsersByTournament_Id(Long Tournament_Id);

}
