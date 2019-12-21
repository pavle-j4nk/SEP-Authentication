package rs.ac.uns.ftn.sep.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sep.authentication.bom.UserAccount;
import rs.ac.uns.ftn.sep.authentication.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = userRepository.findOneByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return User.builder().username(username).password(user.getPassword()).authorities("SELLER", "USER").build();
    }

}
