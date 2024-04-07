package ru.netology.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("User")
                .password(encoder().encode("pw-user"))
                .roles("READ")
                .and()
                .withUser("AdvUser")
                .password(encoder().encode("pw-adv-user"))
                .roles("WRITE")
                .and()
                .withUser("Admin")
                .password(encoder().encode("pw-admin"))
                .roles("READ", "WRITE", "DELETE")
                .and()
                .withUser("Eraser")
                .password(encoder().encode("pw-eraser"))
                .roles("DELETE")
        ;
    }

}
