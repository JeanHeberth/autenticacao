package com.br.projetoautenticacao.service;

import com.br.projetoautenticacao.dto.AuthenticationDTO;
import com.br.projetoautenticacao.dto.LoginResponseDTO;
import com.br.projetoautenticacao.dto.UsuarioRequestDTO;
import com.br.projetoautenticacao.dto.UsuarioResponseDTO;
import com.br.projetoautenticacao.entity.Usuario;
import com.br.projetoautenticacao.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();


    private ModelMapper mapper = new ModelMapper();


    public List<UsuarioResponseDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> mapper.map(usuario, UsuarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO cadastrarFuncionario(UsuarioRequestDTO dto) {

        Optional<Usuario> verificaEmail = usuarioRepository.findEmail(dto.getEmail());
        if (verificaEmail.isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        return new UsuarioResponseDTO(usuarioRepository.save(Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(enconder.encode(dto.getSenha()))
                .build()));
    }

    public LoginResponseDTO validarUsuario(AuthenticationDTO dto) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        var auth = this.authenticationManager.authenticate(userNamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return new LoginResponseDTO(token);


    }

}
