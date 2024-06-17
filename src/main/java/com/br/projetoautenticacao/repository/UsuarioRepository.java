package com.br.projetoautenticacao.repository;

import com.br.projetoautenticacao.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    UserDetails findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT id, email, nome, senha FROM usuario WHERE email =:email")
    Optional<Usuario> findEmail(String email);
}
