package com.br.projetoautenticacao.service;

import com.br.projetoautenticacao.dto.UsuarioRequestDTO;
import com.br.projetoautenticacao.dto.UsuarioResponseDTO;
import com.br.projetoautenticacao.entity.Usuario;
import com.br.projetoautenticacao.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

//    private BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();


    private ModelMapper mapper = new ModelMapper();


    public List<UsuarioResponseDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> mapper.map(usuario, UsuarioResponseDTO.class))
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO cadastrarFuncionario(UsuarioRequestDTO dto) {
        return new UsuarioResponseDTO(usuarioRepository.save(Usuario.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .build()));
    }

}
