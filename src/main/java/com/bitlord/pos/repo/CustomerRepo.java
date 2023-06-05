package com.bitlord.pos.repo;

import com.bitlord.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository< Customer,Long> {


     /*@Query( value = "SELECT * FROM customer WHERE public_id=?1" , nativeQuery = true)
     the thing happened behind this findByPublicId method
      */
    public Optional< Customer > findByPublicId( long id ); // find customer by Public ID


}
