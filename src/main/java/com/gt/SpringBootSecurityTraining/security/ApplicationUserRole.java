package com.gt.SpringBootSecurityTraining.security;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.gt.SpringBootSecurityTraining.security.ApplicationUserPermissions.PROCESS_READ;
import static com.gt.SpringBootSecurityTraining.security.ApplicationUserPermissions.PROCESS_WRITE;

@Getter
@RequiredArgsConstructor
public enum ApplicationUserRole {
    BUSINESS_USER(Sets.newHashSet(PROCESS_READ)),
    ADMINISTRATOR(Sets.newHashSet(PROCESS_READ, PROCESS_WRITE));

    private final Set<ApplicationUserPermissions> permissions;

    public Set<SimpleGrantedAuthority> getGrantAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+ this.name()));
        return permissions;
    }
}
