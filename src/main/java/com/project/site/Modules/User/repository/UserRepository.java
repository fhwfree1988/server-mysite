package com.project.site.Modules.User.repository;

import com.project.site.Modules.User.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends org.springframework.data.repository.Repository<User, Long>/*JpaRepository<User, Long>*/ {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
