package pl.coderslab.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

    User findByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.active = 1 WHERE u.activationCode = :code")
    void updateActivation(@Param("code") String code);

    @Query("SELECT u FROM User u WHERE u.login = :login AND u.active = 1")
    User findActiveUserByLogin(@Param("login") String login);
}
