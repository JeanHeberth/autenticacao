//package com.br.projetoautenticacao.controller;
//
//import com.br.projetoautenticacao.dto.AuthenticationDTO;
//import com.br.projetoautenticacao.dto.RegisterDTO;
//import com.br.projetoautenticacao.entity.Usuario;
//import com.br.projetoautenticacao.repository.UsuarioRepository;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api")
//public class AutheticationController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @PostMapping("/auth")
//    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO dto){
//        var userNamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
//        var auth =  this.authenticationManager.authenticate(userNamePassword);
//
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/usuario")
//    public ResponseEntity register(@RequestBody @Valid RegisterDTO dto){
//        if (usuarioRepository.findByEmail(dto.email()) != null) return ResponseEntity.badRequest().build();
//
//        String encryptedPaswword = new BCryptPasswordEncoder().encode(dto.senha());
//        Usuario usuario = new Usuario(dto.nome(), encryptedPaswword, dto.email());
//
//        usuarioRepository.save(usuario);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Usuario>> listar() {
//        return ResponseEntity.ok(usuarioRepository.findAll());
//    }
//}
