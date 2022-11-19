package tobi4972.olympiade.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String alias;
    private int points;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Tournament tournament;

    @ManyToMany(mappedBy = "users")
    @EqualsAndHashCode.Exclude
    private Set<Team> teams;

}
