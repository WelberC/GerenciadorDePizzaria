package com.sistemapizzaria.sistemapizzaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemapizzaria.sistemapizzaria.models.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {
    Produto findByTitulo(String titulo);
    List<Produto> findByEstaAtivoTrue();
}
