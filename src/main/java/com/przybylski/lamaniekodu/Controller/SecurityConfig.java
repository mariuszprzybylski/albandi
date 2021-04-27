package com.przybylski.lamaniekodu.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails adminDetails = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(adminDetails, userDetails);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/hobby/**", "/health/**", "/post/**").access("hasRole('ADMIN')")
//                .antMatchers("/hobby/sport/registration", "/hobby/sport/firstPage", "/hobby/sport/allCategory", "/health/**", "/post/**").access("hasRole('USER')")
//                .and()
//                .formLogin().loginPage("/")
//                .defaultSuccessUrl("/hobby/sport/registration")
//                .failureUrl("/hobby/sport/zz")
//                .permitAll()
//                .and()
//                .logout().permitAll();
//    }
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/hobby/sport/form")
                //.permitAll()
                .hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/")
                .defaultSuccessUrl("/hobby/sport/form")
                .failureForwardUrl("/failLogin")
                .permitAll()
                .and()
                .logout().permitAll();
    }
}
