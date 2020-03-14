package ru.arkaleks.moscycling.controller;

import lombok.RequiredArgsConstructor;
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
//
//
//    private AuthenticationManager authenticationManager;

    @GetMapping("/cyclepath/login")
    public String login() {
        System.out.println("My login controller");
//        System.out.println("User name is " + name);
//        System.out.println("Passwird is " + password);
//        Authentication request = new UsernamePasswordAuthenticationToken(name, password);
//
//        Authentication result = authenticationManager.authenticate(request);
//        System.out.println(result.getPrincipal());
//        System.out.println(result.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(result);
        return "ok";
    }

}

