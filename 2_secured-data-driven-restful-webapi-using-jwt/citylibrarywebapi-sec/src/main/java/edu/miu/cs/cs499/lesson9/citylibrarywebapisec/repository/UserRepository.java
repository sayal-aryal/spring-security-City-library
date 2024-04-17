package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.repository;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);

}
