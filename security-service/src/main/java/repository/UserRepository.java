package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findFirstByEmail(String email);

    List<User> findAllByLocationContains(String location);

    List<User> findAllByRole_Nom(String role);

}
