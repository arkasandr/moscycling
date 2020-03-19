package ru.arkaleks.moscycling.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/login")
    public String login() {
        System.out.println("My login controller");
        return "ok";
    }

}

