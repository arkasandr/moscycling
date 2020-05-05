package ru.arkaleks.moscycling.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.arkaleks.moscycling.controller.dto.UserDTO;
import ru.arkaleks.moscycling.controller.impl.UserControlService;
import ru.arkaleks.moscycling.model.User;

import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@RequiredArgsConstructor
@RestController
@Transactional
public class UserController {

    private final UserControlService userControlService;

    /**
     * Метод находит всех пользователей User
     *
     * @param
     * @return List<User>
     * @throws
     */
    @GetMapping("/users/all")
    public List<UserDTO> getAllUsers() {
        return userControlService.getAllUsers();
    }


    /**
     * Метод сохраняет или обновляет велодорожку CyclePath
     *
     * @param
     * @return CyclePath
     * @throws
     */
    @PutMapping("/users/adduser")
    UserDTO saveOrUpdate(@RequestBody User newUser) {
   //      userControlService.addNewUser(newUser);
        return userControlService.saveWithUserRole(newUser);
    }

}
