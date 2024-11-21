package com.projeto.projeto.Authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.security.core.userdetails.UserDetails;
import com.projeto.projeto.Authentication.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    UserDetails findByLogin(String login);

}