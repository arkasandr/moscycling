package ru.arkaleks.moscycling.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.arkaleks.moscycling.controller.dto.UserDTO;
import ru.arkaleks.moscycling.controller.dto.UserRoleDTO;
import ru.arkaleks.moscycling.model.User;
import ru.arkaleks.moscycling.model.UserRole;

import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO mapToUserDTO(User userEntity);

    List<UserDTO> mapToUserList(List<User> userEntityList);

    List<UserRoleDTO> mapToUserRoleList(List<UserRole> userRoleEntityList);

}
