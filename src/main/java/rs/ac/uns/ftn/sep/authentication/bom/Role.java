package rs.ac.uns.ftn.sep.authentication.bom;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    private List<UserAccount> users;
}
