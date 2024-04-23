package com.project.site.Modules.User.repository;

import com.project.site.Modules.User.model.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends /*JpaRepository*/CrudRepository<Users, Long> {
  Optional<Users> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
