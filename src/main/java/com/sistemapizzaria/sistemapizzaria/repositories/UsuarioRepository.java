package com.sistemapizzaria.sistemapizzaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemapizzaria.sistemapizzaria.models.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, String>{
    Usuario findByCelular (String celular);
    Usuario findByEmail (String email);
    List<Usuario> findByEstaAtivoTrue();
}
