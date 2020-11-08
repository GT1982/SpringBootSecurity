package com.gt.SpringBootSecurityTraining.dao;

import com.google.common.collect.Lists;
import com.gt.SpringBootSecurityTraining.auth.ApplicationUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.gt.SpringBootSecurityTraining.security.ApplicationUserRole.ADMINISTRATOR;
import static com.gt.SpringBootSecurityTraining.security.ApplicationUserRole.BUSINESS_USER;

@Repository("Temporary")
@RequiredArgsConstructor
public class ApplicationUserDaoImpl implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationsUsers = Lists.newArrayList(
                new ApplicationUser(
                        "gt1982",
                        passwordEncoder.encode("oceanundergreysky"),
                        ADMINISTRATOR.getGrantAuthorities(),
                        true,
                        true,
                        true,
                        true)
                ,
                new ApplicationUser(
                        "ka1986",
                        passwordEncoder.encode("blueskywitharedsun"),
                        BUSINESS_USER.getGrantAuthorities(),
                        true,
                        true,
                        true,
                        true)
        );
        return applicationsUsers;
    }
}
