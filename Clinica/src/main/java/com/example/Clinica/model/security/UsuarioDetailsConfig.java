package com.example.Clinica.model.security;

import com.example.Clinica.model.entity.Usuario;
import com.example.Clinica.model.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class UsuarioDetailsConfig implements UserDetailsService{

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.usuario(login);
        if(usuario == null){
            throw new UsernameNotFoundException("usuário não encontrado!");
        }
        return new User(usuario.getLogin(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
    }

}