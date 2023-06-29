package com.bitlord.pos.repo;

import com.bitlord.pos.entity.UserRoleHasUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface UserRoleHasUserRepo extends JpaRepository<UserRoleHasUser, String >  {

    @Query(value = "SELECT * FROM user_role_has_user WHERE user_id=?1", nativeQuery = true)
    public List<UserRoleHasUser> findByUserId(String userId);

}
