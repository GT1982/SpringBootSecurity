package com.gt.SpringBootSecurityTraining.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.gt.SpringBootSecurityTraining.security.ApplicationUserPermissions.*;
import static com.gt.SpringBootSecurityTraining.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","css/*","js/*","/h2/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/v1/processes/**").hasAuthority(PROCESS_WRITE.getPermission())
                .antMatchers(HttpMethod.GET,"/api/v1/processes/**").hasAnyRole(ADMINISTRATOR.name(), BUSINESS_USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails adminUser = User.builder()
                .username("gt1982")
                .password(passwordEncoder.encode("oceanundergreysky"))
                //.roles(ADMINISTRATOR.name())
                .authorities(ADMINISTRATOR.getGrantAuthorities())
                .build();
        UserDetails customUser = User.builder()
                .username("ka1986")
                .password(passwordEncoder.encode("blueskywitharedsun"))
                //.roles(BUSINESS_USER.name())
                .authorities(BUSINESS_USER.getGrantAuthorities())
                .build();
        return new InMemoryUserDetailsManager(adminUser,customUser);
    }
}
