package com.sistemapizzaria.sistemapizzaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemapizzaria.sistemapizzaria.models.Usuario;
import com.sistemapizzaria.sistemapizzaria.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios/")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/{celular}")
    public ResponseEntity<?> procurarPorCelular(@PathVariable String celular){
        return usuarioService.procurarPorCelular(celular);
    }

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @PutMapping
    public ResponseEntity<?> editarUsuario(@RequestBody Usuario usuario){
        return usuarioService.editarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> apagarUsuario(@RequestBody Usuario usuario, @PathVariable String id){
        return usuarioService.apagarUsuario(id);
    }

}
