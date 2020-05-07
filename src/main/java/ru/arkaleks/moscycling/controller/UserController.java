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
     * Метод сохраняет нового пользователя User
     *
     * @param
     * @return UserDTO
     * @throws
     */
    @ResponseBody
    @PostMapping("/users/addnewuser")
    UserDTO addNewUser(@RequestBody User newUser) {
        userControlService.saveUserWithoutUserRole(newUser);
        userControlService.setUserRoleToUser(newUser);
        return userControlService.addNewUser(newUser);
    }

}
