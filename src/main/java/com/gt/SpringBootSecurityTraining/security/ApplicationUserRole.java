package com.gt.SpringBootSecurityTraining.security;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

import static com.gt.SpringBootSecurityTraining.security.ApplicationUserPermissions.PROCESS_READ;
import static com.gt.SpringBootSecurityTraining.security.ApplicationUserPermissions.PROCESS_WRITE;

@Getter
@RequiredArgsConstructor
public enum ApplicationUserRole {
    BUSINESS_USER(Sets.newHashSet()),
    ADMINISTRATOR(Sets.newHashSet(PROCESS_READ, PROCESS_WRITE));

    private final Set<ApplicationUserPermissions> permissions;
}
