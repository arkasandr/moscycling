package ru.arkaleks.moscycling.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import ru.arkaleks.moscycling.model.User;

        import java.util.Optional;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.userRole WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
