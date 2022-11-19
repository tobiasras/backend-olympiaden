package tobi4972.olympiade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobi4972.olympiade.model.Tournament;
import tobi4972.olympiade.service.ITournamentService;
import tobi4972.olympiade.service.IUserService;
import tobi4972.olympiade.service.TournamentService;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Set;

@CrossOrigin
@RestController
public class TournamentController {

    private ITournamentService tourService;

    public TournamentController(ITournamentService tourService){
        this.tourService = tourService;
    }

    @PostMapping("/tournament/add")
    public ResponseEntity<String> add(@RequestBody Tournament tournament){
        Tournament tour = tourService.save(tournament);
        String msg = "";
        HttpStatus status;


        if (tour != null){
            msg = "Created new tournament: " + tournament.getName();
            status = HttpStatus.OK;
        } else {
            msg = "Could not create: " + tournament.getName();
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(msg, status);
    }

    @GetMapping("tournament/all")
    public ResponseEntity<Set<Tournament>> all(){
        return new ResponseEntity<>(tourService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/tournament/delete")
    public void delete(@RequestParam("id") Long tournamentId){
        // then deletes tournamnent
        tourService.deleteBy(tournamentId);
    }




}
