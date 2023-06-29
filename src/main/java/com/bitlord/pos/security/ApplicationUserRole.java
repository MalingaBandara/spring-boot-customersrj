package com.bitlord.pos.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {

    // user role enums
    ADMIN(Sets.newHashSet()),
    USER(Sets.newHashSet()),
    MANAGER(Sets.newHashSet());

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions(){
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream().map(permission->
                        new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        return permissions;
    }

}