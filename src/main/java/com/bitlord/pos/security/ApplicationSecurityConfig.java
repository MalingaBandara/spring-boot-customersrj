package com.bitlord.pos.security;

import com.bitlord.pos.jwt.JwtConfig;
import com.bitlord.pos.jwt.JwtTokenVerifier;
import com.bitlord.pos.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.bitlord.pos.service.UserService;
import com.bitlord.pos.service.impl.ApplicationUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import javax.crypto.SecretKey;
import java.util.List;


@Configuration // Configuration class
@EnableWebSecurity // Enable Web Security
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserServiceImpl applicationUserService;

    private final UserService userService;

    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, JwtConfig jwtConfig, SecretKey secretKey, ApplicationUserServiceImpl applicationUserService, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
        this.applicationUserService = applicationUserService;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Configuration
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("*"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(false);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));


        //csrf().disable() => dont do that
        http.csrf().disable()
                .cors().configurationSource(request -> corsConfiguration)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter( new JwtUsernameAndPasswordAuthenticationFilter( authenticationManager(), jwtConfig, secretKey ) )
                .addFilterAfter( new JwtTokenVerifier( jwtConfig, secretKey ), JwtUsernameAndPasswordAuthenticationFilter.class )
                .authorizeRequests()
                .antMatchers(
                        "/api/v1/user/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth.authenticationProvider( daoAuthenticationProvider() );
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
            provider.setPasswordEncoder(passwordEncoder);
            provider.setUserDetailsService(applicationUserService);

        return provider;
    }

    /*    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails annaSmithUser =
                User.builder().username("anna")
                        .password(passwordEncoder.encode("1234"))
                        //             .roles(ApplicationUserRole.STUDENT.name()) // ROLE_STUDENT
                        .authorities(STUDENT.getGrantedAuthorities())
                        .build();
        UserDetails lindaUser = User.builder().username("linda")
                .password(passwordEncoder.encode("1234"))
                //   .roles(ApplicationUserRole.ADMIN.name()) // ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();
        UserDetails tomUser = User.builder().username("tom")
                .password(passwordEncoder.encode("1234"))
                //.roles(ApplicationUserRole.ADMINTRANEE.name()) // ROLE_ADMINTRANEE
                .authorities(ADMINTRANEE.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(annaSmithUser, lindaUser, tomUser);
    }*/
}
