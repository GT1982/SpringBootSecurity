//package com.gt.SpringBootSecurityTraining.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//import static com.gt.SpringBootSecurityTraining.security.ApplicationUserPermissions.PROCESS_WRITE;
//import static com.gt.SpringBootSecurityTraining.security.ApplicationUserRole.ADMINISTRATOR;
//import static com.gt.SpringBootSecurityTraining.security.ApplicationUserRole.BUSINESS_USER;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class ApplicationSecurityBasicWithPreAuthConfig extends WebSecurityConfigurerAdapter {
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/","index","css/*","js/*","/h2/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
//
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails adminUser = User.builder()
//                .username("gt1982")
//                .password(passwordEncoder.encode("oceanundergreysky"))
//                //.roles(ADMINISTRATOR.name())
//                .authorities(ADMINISTRATOR.getGrantAuthorities())
//                .build();
//        UserDetails customUser = User.builder()
//                .username("ka1986")
//                .password(passwordEncoder.encode("blueskywitharedsun"))
//                //.roles(BUSINESS_USER.name())
//                .authorities(BUSINESS_USER.getGrantAuthorities())
//                .build();
//        return new InMemoryUserDetailsManager(adminUser,customUser);
//    }
//}
