package rs.ac.uns.ftn.sep.authentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.sep.authentication.bom.UserAccount;
import rs.ac.uns.ftn.sep.authentication.dto.RegistrationDto;
import rs.ac.uns.ftn.sep.authentication.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {
    private final UserService userService;

    @PreAuthorize("isFullyAuthenticated()")
    @GetMapping
    public Map<String, Object> authentication(Authentication authentication) {
        List<String> authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return Map.of("username", authentication.getPrincipal(), "roles", authorities);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registration(RegistrationDto registrationDto) {
        return ResponseEntity.ok(userService.register(registrationDto));
    }

}
