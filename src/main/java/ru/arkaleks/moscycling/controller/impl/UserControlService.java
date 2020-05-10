package ru.arkaleks.moscycling.controller.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.arkaleks.moscycling.controller.dto.UserDTO;
import ru.arkaleks.moscycling.controller.mapper.UserMapper;
import ru.arkaleks.moscycling.model.User;
import ru.arkaleks.moscycling.model.UserRole;
import ru.arkaleks.moscycling.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@RequiredArgsConstructor
@Transactional
@Service
public class UserControlService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserMapper userMapper = UserMapper.INSTANCE;

    /**
     * Метод находит всех пользователей User
     *
     * @param
     * @return List<UserDto>
     * @throws
     */
    public List<UserDTO> getAllUsers() {
        return userMapper.mapToUserList(userRepository.findAll());
    }


    /**
     * Метод сохраняет нового пользователя User без роли UserRole
     *
     * @param
     * @return
     * @throws
     */
    public void saveUserWithoutUserRole(User newUser) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(newUser.getUsername())) {
                throw new IllegalArgumentException("Sorry, User with Username = " + user.getUsername() + " is exists!");
            }
        }
        User addUser = new User(newUser.getUsername(), newUser.getPassword());
        addUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        userRepository.save(addUser);
    }


    /**
     * Метод устанавливает роль UserRole для добавляемого  пользователя User
     *
     * @param
     * @return
     * @throws
     */
    public void setUserRoleToUser(User newUser) {
        List<UserRole> roles = newUser.getUserRole();
        roles.get(0).setUser(userRepository.findByUsername(newUser.getUsername()).get());
        userRepository.findByUsername(newUser.getUsername()).get().setUserRole(roles);
    }

    /**
     * Метод добавляет нового пользователя User в приложение
     *
     * @param
     * @return UserDTO
     * @throws
     */
    public UserDTO addNewUser(User newUser) {
        return userMapper.mapToUserDTO(userRepository.findByUsername(newUser.getUsername()).get());
    }

    /**
     * Метод удаляет пользователя User
     *
     * @param
     * @return
     * @throws
     */
    public void deleteUser(Integer id) {
        List<User> users = userRepository.findAll();
        List<Integer> usersId = new ArrayList<>();
        for(User user : users) {
            usersId.add(user.getId());
        }
        if(usersId.contains(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Sorry, no User ID = " + id + " was found!");
        }
    }

    /**
     * Метод обновляет поле username пользователя User
     *
     * @param
     * @return UserDTO
     * @throws IllegalArgumentException
     */
    public UserDTO updateUsername(Map<String, String> update, String usernameRecent) {
        return userMapper.mapToUserDTO(userRepository.findByUsername(usernameRecent)
                .map(x -> {
                    String newUsername = update.get("username");
                        x.setUsername(newUsername);
                        return userRepository.save(x);
                })
                .orElseGet(() -> {
                     throw new IllegalArgumentException("Sorry, no Username = " + usernameRecent + " was found!");
                }));
    }

}