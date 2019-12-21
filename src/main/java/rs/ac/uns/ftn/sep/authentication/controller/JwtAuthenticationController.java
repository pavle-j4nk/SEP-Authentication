package rs.ac.uns.ftn.sep.authentication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.sep.authentication.service.AuthenticationService;
import rs.ac.uns.ftn.sep.commons.jwtsecurity.dto.JwtRequest;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@CrossOrigin


public class JwtAuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

    @GetMapping("/refresh")
    public ResponseEntity<?> refreshToken(HttpServletRequest request) {
        return ResponseEntity.ok(authenticationService.refresh(request));
    }

}
