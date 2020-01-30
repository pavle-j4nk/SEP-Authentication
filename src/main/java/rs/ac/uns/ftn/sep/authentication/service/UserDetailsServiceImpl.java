package rs.ac.uns.ftn.sep.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sep.authentication.bom.Role;
import rs.ac.uns.ftn.sep.authentication.bom.UserAccount;
import rs.ac.uns.ftn.sep.authentication.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = userRepository.findOneByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return User.builder().username(username).password(user.getPassword()).authorities(authorities).build();
    }

}
