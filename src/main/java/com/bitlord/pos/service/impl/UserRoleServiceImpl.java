package com.bitlord.pos.service.impl;



import com.bitlord.pos.entity.UserRole;
import com.bitlord.pos.repo.UserRoleRepo;
import com.bitlord.pos.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepo userRoleRepo;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepo userRoleRepo) {
        this.userRoleRepo = userRoleRepo;
    }

    @Override
    public void initializeRoles() {

        if (userRoleRepo.findAll().isEmpty()){
            // create users
            UserRole admin = new UserRole("POS-R-1","ADMIN","admin desc",null);
            UserRole user = new UserRole("POS-R-2","USER","user desc",null);
            UserRole manager = new UserRole("POS-R-3","MANAGER","manager desc",null);

            // save users
            userRoleRepo.saveAll(List.of(admin,user,manager));
        }
    }
}