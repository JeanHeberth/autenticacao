package com.br.projetoautenticacao.repository;

import com.br.projetoautenticacao.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    UserDetails findByEmail(String email);

}
