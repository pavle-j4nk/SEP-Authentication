package rs.ac.uns.ftn.sep.authentication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.sep.commons.jwtsecurity.JwtTokenProvider;
import rs.ac.uns.ftn.sep.commons.jwtsecurity.dto.JwtRequest;
import rs.ac.uns.ftn.sep.commons.jwtsecurity.dto.JwtResponse;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

    public JwtResponse authenticate(JwtRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtTokenProvider.createToken(userDetails);

        return new JwtResponse(token);
    }

    public JwtResponse refresh(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);

        String username = jwtTokenProvider.getUsernameFromExpired(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        token = jwtTokenProvider.createToken(userDetails);

        return new JwtResponse(token);
    }

}
