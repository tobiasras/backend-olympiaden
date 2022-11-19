package tobi4972.olympiade.service;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tobi4972.olympiade.model.Tournament;
import tobi4972.olympiade.test_utility.SqlScript;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TournamentServiceTest {

    @Autowired
    ITournamentService service;


    @Test
    @Order(1)
    void setup(){
        SqlScript sqlScript = new SqlScript("src/test/resources/testdata/tournament.sql");
        sqlScript.run();
    }

    @Test
    @Order(2)
    void save() {
        Tournament tournament = new Tournament();
        tournament.setName("Test");
        service.save(tournament);

        Optional<Tournament> opTournament = service.findById(6L);

        assertTrue(opTournament.isPresent());

        Tournament tour = opTournament.get();

        assertEquals("Test", tour.getName());
    }


    @Test
    @Order(3)
    void findAll() {
        Set<Tournament> all = service.findAll();
        assertNotNull(all);

        assertEquals(6, all.size());
    }


    @Test
    @Order(6)
    void deleteBy() {
        Set<Tournament> all = service.findAll();
        int totalSet = all.size();

        service.deleteBy(all.iterator().next().getId());

        Set<Tournament> all2 = service.findAll();
        int totalminus = all2.size();

        assertTrue(totalminus < totalSet);
    }

    @Test
    @Order(4)
    void findById() {
        Tournament tournament = new Tournament();
        tournament.setName("petra");
        service.save(tournament);

        Optional<Tournament> fromDB = service.findById(7L);
        boolean present = fromDB.isPresent();

        assertTrue(present);
        Tournament tournament1 = fromDB.get();

        assertEquals("petra", tournament1.getName());
    }
}