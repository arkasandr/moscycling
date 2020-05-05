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
import ru.arkaleks.moscycling.repository.UserRoleRepository;

import java.util.Arrays;
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

    @Autowired
    private UserRoleRepository userRoleRepository;

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
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
       // userRepository.save(newUser);
        //newUser.setUserRole(Arrays.asList(userRoleRepository.findByRolename("ROLE_ADMIN")));
    //    UserRole role = newUser.getUserRole().get(0).setId(userRepository.findByUsername(newUser.getUsername()).get().getId());
        userRepository.save(newUser);
        return userMapper.mapToUserDTO(newUser);
    }

//    /**
//     * Метод обновляет данные пользователя User
//     *
//     * @param
//     * @return UserDto
//     * @throws
//     */
//    public UserDTO addNewUser(User newUser) {
//        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
//        userRepository.save(newUser);
//        return userMapper.mapToUserDTO(newUser);
//    }
}
