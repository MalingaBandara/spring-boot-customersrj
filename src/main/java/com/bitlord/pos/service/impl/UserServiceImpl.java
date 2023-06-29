package com.bitlord.pos.service.impl;

import com.bitlord.pos.dto.core.UserDto;
import com.bitlord.pos.dto.request.RequestUserDto;
import com.bitlord.pos.exception.EntryNotFoundException;
import com.bitlord.pos.repo.UserRepo;
import com.bitlord.pos.repo.UserRoleRepo;
import com.bitlord.pos.service.UserService;
import com.bitlord.pos.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final UserRoleRepo userRoleRepo;

    private final UserMapper userMapper; // add user mapper


    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserRoleRepo userRoleRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
        this.userMapper = userMapper;
    }


    @Override
    public void createUser(RequestUserDto dto, String role) {

        var selectedUserRole = userRoleRepo.findByRoleName( role ); // get user user role name
            if ( selectedUserRole.isEmpty() ) { // the role not found
                throw new EntryNotFoundException( "User role not found" );
            }

        var selectedUser = userRepo.findUserByEmail( dto.getEmail() );
            if ( selectedUser.isPresent() ) { // If there is a selected user data
                throw new EntryNotFoundException( "User email already exists" );
            }

        // create user dto for save user in db
        UserDto userDto = new UserDto( String.valueOf( new Random().nextInt(1001) ), dto.getEmail(), dto.getFullName(), dto.getPassword() );

        userRepo.save( userMapper.toUser( userDto ) ); // save dto

    }

}
