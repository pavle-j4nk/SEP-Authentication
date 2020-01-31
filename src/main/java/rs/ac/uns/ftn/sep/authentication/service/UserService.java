package rs.ac.uns.ftn.sep.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sep.authentication.bom.Role;
import rs.ac.uns.ftn.sep.authentication.bom.UserAccount;
import rs.ac.uns.ftn.sep.authentication.dto.RegistrationDto;
import rs.ac.uns.ftn.sep.authentication.repository.RoleRepository;
import rs.ac.uns.ftn.sep.authentication.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private static final String ROLE_MERCHANT = "ROLE_MERCHANT";

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserAccount register(RegistrationDto registrationDto) {
        UserAccount user = new UserAccount();

        Role role = roleRepository.findByName(ROLE_MERCHANT);

        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        user.setRoles(List.of(role));

        user = userRepository.save(user);
        return user;
    }
}
