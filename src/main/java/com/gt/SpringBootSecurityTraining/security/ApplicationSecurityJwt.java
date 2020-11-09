package com.gt.SpringBootSecurityTraining.security;

import com.gt.SpringBootSecurityTraining.Jwt.JwtConfig;
import com.gt.SpringBootSecurityTraining.Jwt.JwtTokenVerifier;
import com.gt.SpringBootSecurityTraining.Jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.gt.SpringBootSecurityTraining.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

import static com.gt.SpringBootSecurityTraining.security.ApplicationUserPermissions.PROCESS_WRITE;
import static com.gt.SpringBootSecurityTraining.security.ApplicationUserRole.ADMINISTRATOR;
import static com.gt.SpringBootSecurityTraining.security.ApplicationUserRole.BUSINESS_USER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityJwt extends WebSecurityConfigurerAdapter {

    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(),jwtConfig,secretKey))
                .addFilterAfter(new JwtTokenVerifier(jwtConfig,secretKey),JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/","index","css/*","js/*","/h2/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/v1/processes/**").hasAuthority(PROCESS_WRITE.getPermission())
                .antMatchers(HttpMethod.GET,"/api/v1/processes/**").hasAnyRole(ADMINISTRATOR.name(), BUSINESS_USER.name())
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }
}
