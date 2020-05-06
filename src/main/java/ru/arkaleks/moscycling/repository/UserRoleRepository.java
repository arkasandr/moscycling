package ru.arkaleks.moscycling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.arkaleks.moscycling.model.User;
import ru.arkaleks.moscycling.model.UserRole;

import java.util.Optional;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    Optional<UserRole> findByRolename(String rolename);
}
