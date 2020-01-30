package rs.ac.uns.ftn.sep.authentication.bom;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
}
