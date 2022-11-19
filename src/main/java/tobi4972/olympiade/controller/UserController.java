package tobi4972.olympiade.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobi4972.olympiade.model.Tournament;
import tobi4972.olympiade.model.User;
import tobi4972.olympiade.service.ITournamentService;
import tobi4972.olympiade.service.IUserService;

import java.util.Optional;
import java.util.Set;

@CrossOrigin
@RestController
public class UserController {

    private IUserService service;
    private ITournamentService tourService;


    public UserController(IUserService service, ITournamentService tourService){
        this.service = service;
        this.tourService = tourService;
    }



    @GetMapping("api/get/usersFromTournamentID")
    public ResponseEntity<Set<User>> getUsersFromTournamentID(@RequestParam Long tourId){
        return new ResponseEntity<>(service.findByTournamentID(tourId), HttpStatus.OK);
    }



    @PostMapping("api/create/user")
    public ResponseEntity<String> createUser(@RequestBody User user, @RequestParam Long tourId){

        Optional<Tournament> tournamentOptional = tourService.findById(tourId);

        if (tournamentOptional.isPresent()){
            user.setTournament(tournamentOptional.get());

            service.save(user);

            return new ResponseEntity<>("brugere oprettet", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Kunne ikke oprette", HttpStatus.BAD_REQUEST);
        }
    }





}
