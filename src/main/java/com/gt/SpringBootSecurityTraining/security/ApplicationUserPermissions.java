package com.gt.SpringBootSecurityTraining.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApplicationUserPermissions {
    PROCESS_READ("process:read"),
    PROCESS_WRITE("process:write");

    private final String permission;
}
