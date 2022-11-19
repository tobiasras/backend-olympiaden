package tobi4972.olympiade.service;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import tobi4972.olympiade.model.Tournament;
import tobi4972.olympiade.model.User;
import tobi4972.olympiade.test_utility.SqlScript;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    IUserService service;
    @Autowired
    ITournamentService tournamentService;

    @Test
    @Order(1)
    void setup(){
        // Before all method runs before database setup
        SqlScript sqlScript = new SqlScript("src/test/resources/testdata/user.sql");
        sqlScript.run();
    }

    @Test
    @Order(2)
    void findAll() {
        // test script creates 10 user objects
        Set<User> all = service.findAll();

        assertEquals(10, all.size());

        Iterator<User> iterator = all.iterator();

        while (iterator.hasNext()){
            User next = iterator.next();
            assertNotNull(next);


        }
    }


    @Test
    @Order(2)
    void findByTournamentID(){
        Set<User> users = service.findByTournamentID(2L);
        assertEquals(5, users.size());


    }

    @Test
    @Order(3)
    void deleteAllByTournamentID() {
        service.deleteAllByTournamentID(2L);
        Set<User> all = service.findAll();
        assertEquals(5, all.size());

    }

    @Test
    @Order(3)
    void findById() {
        Optional<User> exist = service.findById(1L);
        Optional<User> notExist = service.findById(100L);

        assertTrue(exist.isPresent());
        assertEquals("Test 1", exist.get().getAlias());

        assertFalse(notExist.isPresent());
    }



    @Test
    @Order(4)
    void save() {
        Optional<Tournament> byId = tournamentService.findById(1L);
        Tournament tournament = byId.get();

        User user = new User();
        user.setName("New name for test");
        user.setTournament(tournament);

        service.save(user);

        Optional<User> savedUser = service.findById(11L);

        assertTrue(savedUser.isPresent());
        assertEquals("New name for test", savedUser.get().getName());

    }


    @Test
    @Order(6)
    void deleteBy() {
        Set<User> allUsers = service.findAll();
        int totalUsers = allUsers.size();

        service.deleteBy(5L);

        Set<User> allUsersAfterDelete = service.findAll();
        int totalUsersAfterDelete = allUsersAfterDelete.size();

        assertNotEquals(totalUsers, totalUsersAfterDelete);

        Optional<User> savedUserAfterDelete = service.findById(5L);
        assertTrue(savedUserAfterDelete.isEmpty());

    }


}