package com.softserve.travelagency.model.enums;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Set;
import java.util.stream.Collectors;

public enum UserEnums {
    USER(Set.of(Permission.DEVELOPERS_BOOK)),
    ADMIN(Set.of(Permission.DEVELOPERS_EDIT, Permission.DEVELOPERS_BOOK));

    UserEnums(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    private final Set<Permission> permissions;

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}