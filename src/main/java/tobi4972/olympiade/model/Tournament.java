package tobi4972.olympiade.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Game> games;


    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<User> users;


    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Team> teams;



}
