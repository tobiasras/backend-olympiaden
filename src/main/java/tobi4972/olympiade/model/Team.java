package tobi4972.olympiade.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Tournament tournament;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "team_player",
            joinColumns = @JoinColumn(name = "teams"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<User> users;




    @ManyToMany(mappedBy = "teams")
    @EqualsAndHashCode.Exclude
    private Set<Game> games;

}
