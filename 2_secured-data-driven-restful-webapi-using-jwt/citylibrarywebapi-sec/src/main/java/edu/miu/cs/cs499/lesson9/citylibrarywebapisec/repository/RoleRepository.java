package edu.miu.cs.cs499.lesson9.citylibrarywebapisec.repository;

import edu.miu.cs.cs499.lesson9.citylibrarywebapisec.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(String roleName);

}
