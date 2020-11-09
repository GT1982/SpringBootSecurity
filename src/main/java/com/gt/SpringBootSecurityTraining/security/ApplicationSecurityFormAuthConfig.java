//package com.gt.SpringBootSecurityTraining.security;
//
//import com.gt.SpringBootSecurityTraining.service.ApplicationUserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.concurrent.TimeUnit;
//
//import static com.gt.SpringBootSecurityTraining.security.ApplicationUserPermissions.PROCESS_WRITE;
//import static com.gt.SpringBootSecurityTraining.security.ApplicationUserRole.ADMINISTRATOR;
//import static com.gt.SpringBootSecurityTraining.security.ApplicationUserRole.BUSINESS_USER;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class ApplicationSecurityFormAuthConfig extends WebSecurityConfigurerAdapter {
//
//    private final PasswordEncoder passwordEncoder;
//    private final ApplicationUserService applicationUserService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/","index","css/*","js/*","/h2/**").permitAll()
//                .antMatchers(HttpMethod.POST,"/api/v1/processes/**").hasAuthority(PROCESS_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET,"/api/v1/processes/**").hasAnyRole(ADMINISTRATOR.name(), BUSINESS_USER.name())
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/business_processes", true)
//                .and()
//                .rememberMe()
//                    .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
//                    .key("secret_key")
//                .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .clearAuthentication(true)
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID","remember-me")
//                    .logoutSuccessUrl("/login");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(passwordEncoder);
//        provider.setUserDetailsService(applicationUserService);
//        return provider;
//    }
//}
