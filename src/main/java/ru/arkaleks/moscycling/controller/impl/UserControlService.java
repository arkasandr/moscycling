package ru.arkaleks.moscycling.controller.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.arkaleks.moscycling.controller.dto.UserDTO;
import ru.arkaleks.moscycling.controller.mapper.UserMapper;
import ru.arkaleks.moscycling.model.User;
import ru.arkaleks.moscycling.repository.UserRepository;

import java.util.List;

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

//    @Autowired
//    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserMapper userMapper = UserMapper.INSTANCE;

    /**
     * Метод находит все CyclePath
     *
     * @param
     * @return List<CyclePathDto>
     * @throws
     */
    public List<UserDTO> getAllUsers() {
        return userMapper.mapToUserList(userRepository.findAll());
    }


    public UserDTO saveWithUserRole(User newUser) {
        return userMapper.mapToUserDTO(userRepository.findByUsername(newUser.getUsername())
                .map(x -> {
        x.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        x.setUserRole(newUser.getUserRole());
                    return userRepository.save(x);
                })
                .orElseGet(() -> {
                    newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
                    newUser.setUserRole(newUser.getUserRole());
                    return userRepository.save(newUser);
                }));
    }

    /**
     * Метод обновляет данные пользователя User
     *
     * @param
     * @return UserDto
     * @throws
     */
    public UserDTO addNewUser(User newUser) {
        return userMapper.mapToUserDTO(userRepository.findByUsername(newUser.getUsername())
                .map(x -> {
                    x.setPassword(newUser.getPassword());
                    return userRepository.save(x);
                })
                .orElseGet(() -> {
                    return userRepository.save(newUser);
                }));
    }
}
