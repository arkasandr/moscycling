package ru.arkaleks.moscycling.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@RequiredArgsConstructor
@RestController
@Transactional
public class CustomLoginController {

    private AuthenticationManager authenticationManager;

    @Autowired
    private RememberMeServices rememberMeServices;

    @PostMapping("/login")
    public ResponseEntity login(final HttpServletRequest request, final HttpServletResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        rememberMeServices.loginSuccess(request, response, authentication);
        System.out.println("My login controller");
        return ResponseEntity.ok(new HashMap<>());
    }

}

