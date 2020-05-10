package ru.arkaleks.moscycling.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.arkaleks.moscycling.controller.dto.UserDTO;
import ru.arkaleks.moscycling.controller.impl.UserControlService;
import ru.arkaleks.moscycling.model.User;

import java.util.List;
import java.util.Map;

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

    /**
     * Метод удаляет пользователя User
     *
     * @param
     * @return
     * @throws
     */
    @DeleteMapping("/users/{user_id}")
    void deleteUser(@PathVariable int user_id) {
        userControlService.deleteUser(user_id);
    }


    /**
     * Метод обновляет только поле "Username" пользователя User
     *
     * @param
     * @return UserDTO
     * @throws
     */
    @PatchMapping("/users/{usernameRecent}")
    UserDTO patchUsername(@RequestBody Map<String, String> update, @PathVariable String usernameRecent) {
        return userControlService.updateUsername(update, usernameRecent);
    }


}
