package com.project.site.my.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends org.springframework.data.repository.Repository<User2, Long>/*JpaRepository<User2, Long>*/{

}