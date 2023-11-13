package com.example.Clinica.model.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        customizer ->
                                customizer
                                        //.requestMatchers("/").permitAll()
                                        .requestMatchers("/consulta/list").permitAll()
                                        .requestMatchers("/consulta/form").hasAnyRole("ADMIN")
                                        .requestMatchers("/consulta/list").hasAnyRole("USER","ADMIN")
                                        .requestMatchers("/medicos/form").hasAnyRole("ADMIN")
                                        .requestMatchers("/medicos/list").hasAnyRole("USER","ADMIN")
                                        .requestMatchers("/pacientes/form").hasAnyRole("ADMIN")
                                        .requestMatchers("/pacientes/list").hasAnyRole("USER","ADMIN")
                                        .requestMatchers(HttpMethod.POST,"/consulta/save").permitAll()
                                        .anyRequest() //define que a configuração é válida para qualquer requisição.
                                        .authenticated() //define que o usuário precisa estar autenticado.
                )
                .formLogin(customizer ->
                        customizer
                                .loginPage("/login") //passamos como parâmetro a URL para acesso à página de login que criamos
                                .defaultSuccessUrl("/consulta/list", true)
                                .permitAll() //define que essa página pode ser acessada por todos, independentemente do usuário estar autenticado ou não.
                )
                .httpBasic(withDefaults()) //configura a autenticação básica (usuário e senha)
                .logout(LogoutConfigurer::permitAll) //configura a funcionalidade de logout no Spring Security.
                .rememberMe(withDefaults()); //permite que os usuários permaneçam autenticados mesmo após o fechamento do navegador
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("user")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}