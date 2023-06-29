package com.bitlord.pos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;


@Configuration // Configuration class
@EnableWebSecurity // Enable Web Security
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Configuration
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("DELETE", "GET", "PUT", "POST", "PATCH", "OPTION"));
        corsConfiguration.setAllowCredentials(false);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));


        //csrf().disable() => dont do that
        http.csrf().disable()
                .cors().configurationSource(request -> corsConfiguration)
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/api/v1/user/register/**"
                ).permitAll()
                .anyRequest()
                .permitAll();

    }

}
