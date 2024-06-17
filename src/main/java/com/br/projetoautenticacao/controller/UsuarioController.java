package com.br.projetoautenticacao.controller;


import com.br.projetoautenticacao.dto.AuthenticationDTO;
import com.br.projetoautenticacao.dto.UsuarioRequestDTO;
import com.br.projetoautenticacao.dto.UsuarioResponseDTO;
import com.br.projetoautenticacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/auth")
    public ResponseEntity login(@RequestBody AuthenticationDTO dto) {
      return ResponseEntity.ok(usuarioService.validarUsuario(dto));
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioResponseDTO> cadastrarFuncionario(@RequestBody UsuarioRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.cadastrarFuncionario(dto));
    }
}
