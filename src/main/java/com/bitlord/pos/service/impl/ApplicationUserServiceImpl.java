package com.bitlord.pos.service.impl;

import com.bitlord.pos.entity.ApplicationUser;
import com.bitlord.pos.entity.UserRoleHasUser;
import com.bitlord.pos.repo.UserRepo;
import com.bitlord.pos.repo.UserRoleHasUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.bitlord.pos.security.ApplicationUserRole.*;

@Service
public class ApplicationUserServiceImpl implements UserDetailsService {
    private final UserRepo userRepo;
    private final UserRoleHasUserRepo userRoleHasUserRepo;

    @Autowired
    public ApplicationUserServiceImpl(UserRepo userRepo, UserRoleHasUserRepo userRoleHasUserRepo) {
        this.userRepo = userRepo;
        this.userRoleHasUserRepo = userRoleHasUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var selectedUser = userRepo.findUserByEmail(username);

        if (selectedUser.isEmpty()) {
            throw new UsernameNotFoundException(
                    String.format("username %s not found", username)
            );
        }

        List<UserRoleHasUser> userRoles = userRoleHasUserRepo.findByUserId(selectedUser.get().getUserId()); // get all user role in particular user

        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>(); // create ApplicationUserRole grantedAuthorities object

            for (UserRoleHasUser uRole : userRoles) {

                if (uRole.getUserRole().equals("USER")) {
                    grantedAuthorities.addAll(USER.getSimpleGrantedAuthorities());
                }
                if (uRole.getUserRole().equals("ADMIN")) {
                    grantedAuthorities.addAll(ADMIN.getSimpleGrantedAuthorities());
                }
                if (uRole.getUserRole().equals("MANAGER")) {
                    grantedAuthorities.addAll(MANAGER.getSimpleGrantedAuthorities());
                }
            }

        ApplicationUser user = new ApplicationUser(
                grantedAuthorities, selectedUser.get().getPassword(),
                selectedUser.get().getEmail(),
                selectedUser.get().isAccountNonExpired(),
                selectedUser.get().isAccountNonLocked(),
                selectedUser.get().isCredentialsNonExpired(),
                selectedUser.get().isEnabled()
        );

        return user;

    }

}
