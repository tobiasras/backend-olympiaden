package tobi4972.olympiade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobi4972.olympiade.model.Team;
import tobi4972.olympiade.service.ITeamService;

import java.util.Set;

@CrossOrigin
@RestController
public class TeamController {

   private ITeamService teamService;

    public TeamController(ITeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/api/get/allTeamsFromTournamentID")
    public ResponseEntity<Set<Team>> getAllTeamsFromTournamentID(@RequestParam("tournamentID") Long tournamentID){
        Set<Team> byTournamentID = teamService.findAllByTournamentID(tournamentID);
        return new ResponseEntity<>(byTournamentID, HttpStatus.OK);
    }


    @GetMapping("api/create/team")
    public ResponseEntity<String> createTeam(@RequestBody Team team){
        Team teamSaved = teamService.save(team);

        if(teamSaved != null){
           return new ResponseEntity<>("team created", HttpStatus.OK);
        } else {
           return new ResponseEntity<>("could not create team", HttpStatus.BAD_REQUEST);
        }

    }





}
