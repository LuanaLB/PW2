package com.example.Clinica.model.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UsuarioDetailsConfig usuarioDetailsConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        customizer ->
                                customizer
                                        .requestMatchers("/").permitAll()
                                        .requestMatchers("/home").permitAll()
                                        .requestMatchers("/consulta/form").hasAnyRole("ADMIN")
                                        .requestMatchers("/consulta/edit/*").hasAnyRole("ADMIN")
                                        .requestMatchers("/consulta/remove/*").hasAnyRole("ADMIN")
                                        .requestMatchers("/medicos/form").hasAnyRole("ADMIN")
                                        .requestMatchers("/medicos/edit/*").hasAnyRole("ADMIN")
                                        .requestMatchers("/medicos/remove/*").hasAnyRole("ADMIN")
                                        .requestMatchers("/pacientes/form").hasAnyRole("ADMIN")
                                        .requestMatchers("/pacientes/edit/*").hasAnyRole("ADMIN")
                                        .requestMatchers("/pacientes/remove/*").hasAnyRole("ADMIN")
                                        //.requestMatchers(HttpMethod.POST,"/consulta/save").permitAll()
                                        .anyRequest()
                                        .authenticated()
                )
                .formLogin(customizer ->
                        customizer
                                .loginPage("/login")
                                .defaultSuccessUrl("/home", true)
                                .permitAll()
                )
                .httpBasic(withDefaults())
                .logout(LogoutConfigurer::permitAll)
                .rememberMe(withDefaults());
        return http.build();
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user1 = User.withUsername("user")
//                .password(passwordEncoder().encode("123"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, admin);
//    }


    @Autowired
    public void configureUserDetails(final AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(usuarioDetailsConfig).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}