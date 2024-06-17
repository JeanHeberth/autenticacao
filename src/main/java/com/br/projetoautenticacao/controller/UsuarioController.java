//package com.br.projetoautenticacao.controller;
//
//
//import com.br.projetoautenticacao.dto.AuthenticationDTO;
//import com.br.projetoautenticacao.dto.UsuarioRequestDTO;
//import com.br.projetoautenticacao.dto.UsuarioResponseDTO;
//import com.br.projetoautenticacao.service.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class UsuarioController {
//
//    @Autowired
//    UsuarioService usuarioService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping("/auth")
//    public ResponseEntity login(@RequestBody AuthenticationDTO dto){
//        var userNamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
//        var auth =  this.authenticationManager.authenticate(userNamePassword);
//
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping
//    public ResponseEntity<List<UsuarioResponseDTO>> listar() {
//        return ResponseEntity.ok(usuarioService.listarUsuarios());
//    }
//
//    @PostMapping("/usuario")
//    public ResponseEntity<UsuarioResponseDTO> cadastrarFuncionario(@RequestBody UsuarioRequestDTO dto) {
//        return ResponseEntity.ok(usuarioService.cadastrarFuncionario(dto));
//    }
//}
