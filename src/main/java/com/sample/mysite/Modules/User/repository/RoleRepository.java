package com.sample.mysite.Modules.User.repository;


import com.sample.mysite.Modules.User.model.entity.Role;
import com.sample.mysite.Modules.User.model.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(RoleType name);
}
