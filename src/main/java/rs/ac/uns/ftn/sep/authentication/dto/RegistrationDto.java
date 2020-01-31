package rs.ac.uns.ftn.sep.authentication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    private String email;

    private String password;

    private String firstName;

    private String lastName;
}
