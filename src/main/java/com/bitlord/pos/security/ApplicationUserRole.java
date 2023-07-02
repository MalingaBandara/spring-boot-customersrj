package com.bitlord.pos.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {

    // user role enums
    USER(Sets.newHashSet()),

    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet()),
    MANAGER(Sets.newHashSet()),
    DEVELOPER(Sets.newHashSet()),
    COMPANY(Sets.newHashSet()),
    LECTURER(Sets.newHashSet());

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){

        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                                                                            .map(permission-> new SimpleGrantedAuthority(permission.getPermission()))
                                                                            .collect(Collectors.toSet());

        permissions.add( new SimpleGrantedAuthority( "ROLE_" + this.name() ) );

        return permissions;

    }

}