package com.sistemapizzaria.sistemapizzaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemapizzaria.sistemapizzaria.models.Produto;
import com.sistemapizzaria.sistemapizzaria.services.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos/")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<?> listarTodos(){
        return produtoService.listarTodos();
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<?> procurarPorTitulo(@PathVariable String titulo){
        return produtoService.procurarPorTitulo(titulo);
    }

    @PostMapping
    public ResponseEntity<?> cadastrarProduto(@RequestBody Produto produto){
        return produtoService.cadastrarProduto(produto);
    }

    @PutMapping
    public ResponseEntity<?> editarProduto(@RequestBody Produto produto){
        return produtoService.editarProduto(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> apagarProduto(@PathVariable Long id){
        return produtoService.apagarProduto(id);
    }

}
