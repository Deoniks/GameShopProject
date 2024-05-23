package com.GameShop.GameShop.security;
/*
import com.GameShop.GameShop.domain.authorization.GamerLogin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;*/


/*@Configuration
@EnableWebSecurity*/
public class SecurityConfig{
/*    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/registration","/login").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(GamerLoginService gamerLoginService){
        return gamer -> {
            GamerLogin gamerLogin = gamerLoginService.findByLogin(gamer);
            return org.springframework.security.core.userdetails.User.withUsername(gamerLogin.getLogin())
                    .password(gamerLogin.getPassword())
                    .authorities("USER")
                    .build();
        };
    }*/
}
