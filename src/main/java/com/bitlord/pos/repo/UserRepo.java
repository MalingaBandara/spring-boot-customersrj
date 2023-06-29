package com.bitlord.pos.repo;


import com.bitlord.pos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, String> {

    public Optional<User> findUserByEmail ( String email );

}