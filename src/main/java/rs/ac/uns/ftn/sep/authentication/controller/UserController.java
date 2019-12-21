package rs.ac.uns.ftn.sep.authentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("")
@RestController
@CrossOrigin()
public class UserController {

    @PreAuthorize("isFullyAuthenticated()")
    @GetMapping
    public Map<String, Object> authentication(Authentication authentication) {
        List<String> authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return Map.of("username", authentication.getPrincipal(), "roles", authorities);
    }

}
