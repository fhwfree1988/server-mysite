package com.project.site.Modules.User.repository;

import com.project.site.Modules.User.model.entity.RoleType;
import com.project.site.Modules.User.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends org.springframework.data.repository.Repository<Role, Long>/*JpaRepository<Role, Long>*/ {
  Optional<Role> findByName(RoleType name);
}
