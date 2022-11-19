package tobi4972.olympiade.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Tournament tournament;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "team_game",
            joinColumns = @JoinColumn(name = "teams"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<Team> teams;

}
