package com.sistemapizzaria.sistemapizzaria.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sistemapizzaria.sistemapizzaria.models.Produto;
import com.sistemapizzaria.sistemapizzaria.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    //todos vão poder listar
    public ResponseEntity<?> listarTodos(){
        return new ResponseEntity<>(produtoRepository.findByEstaAtivoTrue(), HttpStatus.OK);
    }

    //Todos vão poder procurar por título (cliente vai buscar produto q deseja comprar; cozinha e adm vao fazer a gestão daquele produto)
    public ResponseEntity<?> procurarPorTitulo(String titulo){
        if(produtoRepository.findByTitulo(titulo) == null){
            return new ResponseEntity<>("Não encontramos nenhum resultado para a pesquisa: " + titulo, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produtoRepository.findByTitulo(titulo), HttpStatus.OK);
    }
    
    //ADMs e cozinha poderão cadastrar novos produtos
    public ResponseEntity<?> cadastrarProduto(Produto produto){
        return new ResponseEntity<>(produtoRepository.save(produto), HttpStatus.CREATED);
    }

    //Só ADMs vão poder editar um produto (preço, descricao, foto etc)
    public ResponseEntity<?> editarProduto(Produto produto){
        Optional <Produto> produtoAntesDaEdicaoOPT= produtoRepository.findById(produto.getId());

        if(produtoAntesDaEdicaoOPT.isEmpty()){
            return new ResponseEntity<>("Produto não encontrado!", HttpStatus.NOT_FOUND);
        }

        Produto produtoAntesDaEdicao = produtoAntesDaEdicaoOPT.get();
        BeanUtils.copyProperties(produto, produtoAntesDaEdicao);
        return new ResponseEntity<>(produtoRepository.save(produtoAntesDaEdicao), HttpStatus.OK);
    }

    //SOFT DELETE. Só ADMs vão poder apagar um produto
    public ResponseEntity<?> apagarProduto(Long id){
        Optional <Produto> produtoPorID= produtoRepository.findById(id);
        
        if(produtoPorID.isEmpty()){
            return new ResponseEntity<>("Não existe um produto com este ID!", 
            HttpStatus.NOT_FOUND);
        }

        Produto produtoExistente= produtoPorID.get();
        produtoExistente.setEstaAtivo(false);
        produtoRepository.save(produtoExistente);

        return new ResponseEntity<>("Produto apagado com sucesso!", HttpStatus.OK);
    }

    

}
