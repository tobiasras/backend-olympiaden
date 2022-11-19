package tobi4972.olympiade.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobi4972.olympiade.model.Team;
import tobi4972.olympiade.model.User;
import tobi4972.olympiade.test_utility.SqlScript;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TeamServiceTest {

    @Autowired
    TeamService teamService;
    @Autowired
    UserService userService;

    @Test
    @Order(5)
    void setup(){
        SqlScript sqlScript = new SqlScript("src/test/resources/testdata/team.sql");
        sqlScript.run();

        int five = 5;
        int four = 4;


    }


    @Test
    @Order(10)
    void findAll() {
        Set<Team> all = teamService.findAll();
        assertEquals(5, all.size());

        Iterator<Team> iterator = all.iterator();
        if (iterator.hasNext()){
            Team next = iterator.next();

            assertNotNull(next);
        }
    }

    @Test
    @Order(15)
    void findAllByTournamentID() {
        Set<Team> allByTournamentID = teamService.findAllByTournamentID(1L);

        assertEquals(5, allByTournamentID.size());
    }


    @Test
    @Order(20)
    void findById() {
        Optional<Team> id = teamService.findById(1L);

        if (id.isPresent()){
            Team team = id.get();
            assertEquals("team 1", team.getName());
        }


    }


    @Test
    @Order(30)
    void save() {
        Optional<Team> opTeam = teamService.findById(1L);
        Team team = opTeam.get();
        Set<User> users = userService.findAll();
        team.setUsers(users);
        teamService.save(team);

        Optional<Team> opAfterSave = teamService.findById(1L);
        Team teamAfterSave = opAfterSave.get();

        Set<User> usersAfterSave = teamAfterSave.getUsers();

        for(User user: users){
            System.out.println(user.getAlias());
        }

        for(User user: usersAfterSave){
            System.out.println(user.getAlias());
        }


        assertEquals(users, usersAfterSave);
    }

    @Test
    @Order(40)
    void deleteBy() {

    }



}