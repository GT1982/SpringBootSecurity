package com.gt.SpringBootSecurityTraining.dao;

import com.gt.SpringBootSecurityTraining.auth.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {

    public Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
