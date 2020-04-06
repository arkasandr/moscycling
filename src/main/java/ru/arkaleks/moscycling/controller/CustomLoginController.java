package ru.arkaleks.moscycling.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/login")
    public ResponseEntity login() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        System.out.println("My login controller");
        return ResponseEntity.ok(new HashMap<>());
    }

//    @RolesAllowed("ROLE_ADMIN")
//    @GetMapping("/editor")
//    public ResponseEntity editorPage() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", "application/json");
//        System.out.println("Enter editor page");
//        return ResponseEntity.ok(new HashMap<>());
//    }


}

